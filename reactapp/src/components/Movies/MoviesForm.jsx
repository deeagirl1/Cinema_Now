import { React, useRef, useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import MoviesService from "../services/MoviesService";
import RoomService from "../services/RoomService";
import ProjectionService from "../services/ProjectionService";
import { store } from "react-notifications-component";

const PostMovie = () => {
  const notificationSuccessful = {
    title: "Successful",
    message: "Movie added successfully!",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 2500,
    },
  };
  const notificationUnSuccessful = {
    title: "Something went wrong!",
    message: "Please try again!",
    type: "danger",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 1000,
    },
  };

  const [genreItems, setGenre] = useState([]);
  const [selectedGenre, setSelectedGenre] = useState([]);

  const [formatItems, setFormats] = useState([]);
  const [selectedFormats, setSelectFormats] = useState([]);

  const [roomItems, setRooms] = useState([]);
  const [selectedRoom, setSelectedRoom] = useState(null);

  const [projectionItems, setProjection] = useState([]);
  const [selectedProjection, setSelectedProjection] = useState(null);

  useEffect(() => {
    MoviesService.getGenres().then((response) => {
      setGenre(response.data);
    });
  }, []);

  useEffect(() => {
    MoviesService.getFormats().then((response) => {
      setFormats(response.data);
    });
  }, []);

  useEffect(() => {
    RoomService.getRooms().then((response) => {
      setRooms(response.data);
    });
  }, []);

  useEffect(() => {
    ProjectionService.getProjections().then((response) => {
      console.log(response.data);
      setProjection(response.data);
    });
  }, []);

  const movieName = useRef();
  const movieGenre = useRef();
  const movieDuration = useRef();
  const movieReleaseDate = useRef();
  const movieDescription = useRef();
  const movieFormat = useRef();
  const movieDirector = useRef();
  const movieRoom = useRef();
  const movieProjection = useRef();

  const handleChangeGenre = (e) => {
    let obj = e.target.value; //genre object

    setSelectedGenre(obj);
  };
  const handleChangeFormat = (e) => {
    let obj = e.target.value; //format object

    setSelectFormats(obj);
  };
  const handleChangeRoom = (e) => {
    let obj = e.target.value; //format object

    setSelectedRoom(JSON.parse(obj));
  };
  const handleChangeProjection = (e) => {
    const selectedOptions = e.target.selectedOptions;

    const newProjections = [];
    for (let i = 0; i < selectedOptions.length; i++) {
      newProjections.push(JSON.parse(selectedOptions[i].value));
    }
    console.log(newProjections);
    setSelectedProjection(newProjections);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const movieNameRef = movieName.current.value;
    const movieGenreRef = selectedGenre;
    const movieDurationRef = movieDuration.current.value;
    const movieReleaseDateRef = movieReleaseDate.current.value;
    const movieDescriptionRef = movieDescription.current.value;
    const movieFormatRef = selectedFormats;
    const movieDirectorRef = movieDirector.current.value;
    const movieRoomRef = selectedRoom.id;

    const movie = {
      name: movieNameRef,
      genre: movieGenreRef,
      duration: movieDurationRef,
      releaseDate: movieReleaseDateRef,
      description: movieDescriptionRef,
      format: movieFormatRef,
      director: movieDirectorRef,
      roomId: movieRoomRef,
      projections: selectedProjection,
    };

    console.log(movie);

    MoviesService.createMovie(movie)
      .then((response) => {
        if (response.data !== null) {
          store.addNotification({
            ...notificationSuccessful,
            container: "top-center",
          });
          window.location.reload();
        }
      })
      .catch((_err) => {
        store.addNotification({
          ...notificationUnSuccessful,
          container: "top-center",
        });
      });
  };

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Title: </Form.Label>
          <Form.Control
            type="text"
            ref={movieName}
            id="title"
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Genre: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeGenre} id="genre" required>
            <option value=""> -- Select a genre -- </option>
            {genreItems.map((option, index) => (
              <option key={index} value={option} ref={movieGenre}>
                {option}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Release Date: </Form.Label>
          <Form.Control
            type="text"
            ref={movieReleaseDate}
            id="releaseDate"
            placeholder="Select the release date..."
            required
          />
        </Form.Group>
        <br />

        <Form.Group>
          <Form.Label>Duration: </Form.Label>
          <Form.Control
            type="number"
            ref={movieDuration}
            id="duration"
            placeholder="Write the duration of the movie in minutes..."
            min="0"
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Description: </Form.Label>
          <Form.Control
            type="text"
            id="description"
            ref={movieDescription}
            placeholder="Write the description of the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Format: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeFormat} id="format" required>
            <option value=""> -- Select a format -- </option>
            {formatItems.map((option, index) => (
              <option key={index} value={option} ref={movieFormat}>
                {option}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Director: </Form.Label>
          <Form.Control
            type="text"
            id="director"
            ref={movieDirector}
            placeholder="Write a title..."
            required
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Room: </Form.Label>
          <br />
          <Form.Control
            as="select"
            onChange={handleChangeRoom}
            required
            id="room"
          >
            <option value=""> -- Select a room -- </option>
            {roomItems.map((option, index) => (
              <option
                key={index}
                value={JSON.stringify(option)}
                ref={movieRoom}
              >
                {option.name}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Projections: </Form.Label>
          <br />
          <Form.Control
            as="select"
            multiple
            onChange={handleChangeProjection}
            required
            id="projection"
          >
            {projectionItems.map((option, index) => (
              <option
                key={index}
                value={JSON.stringify(option)}
                ref={movieProjection}
              >
                {option.date} {option.time}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Button variant="primary" type="submit" id="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostMovie;
