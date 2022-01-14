import { React, useRef, useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import MoviesService from "../services/MoviesService";
import RoomService from "../services/RoomService";
import ProjectionService from "../services/ProjectionService";

const EditMovie = () => {

  let param = window.location.pathname;
  let id = param.split("/").pop();
  
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
    MoviesService.getFormats().then((response) => {
      setFormats(response.data);
    });
    RoomService.getRooms().then((response) => {
      setRooms(response.data);
    });
    ProjectionService.getProjections().then((response) => {
      console.log(response.data);
      setProjection(response.data);
    });

  }, []);




  const [movie, setMovie] = useState(null);

  useEffect(() => {
    MoviesService.getMoviesById(id).then((response) => {
      console.log(response.data);
      setMovie(response.data);
    });
  }, [id]);

  const handleChangeGenre = (e) => {
    let obj = e.target.value; //genre object
    setSelectedGenre(obj);
  };
  const handleChangeFormat = (e) => {
    let obj = e.target.value; //format object
    setSelectFormats(obj);
  };
  const handleChangeRoom = (e) => {
    let obj = e.target.value; //room object
    console.log(obj);
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

  const movieName = useRef();
  const movieDuration = useRef();
  const movieReleaseDate = useRef();
  const movieDescription = useRef();
  const movieDirector = useRef();
  const movieProjectionRef = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    const enteredMovieName = movieName.current.value;
    const movieGenreRef = selectedGenre;
    const movieDurationRef = movieDuration.current.value;
    const movieReleaseDateRef = movieReleaseDate.current.value;
    const movieDescriptionRef = movieDescription.current.value;
    const movieFormatRef = selectedFormats;
    const movieDirectorRef = movieDirector.current.value;

    const movie = {
      id: id,
      name: enteredMovieName,
      genre: movieGenreRef,
      duration: movieDurationRef,
      releaseDate: movieReleaseDateRef,
      description: movieDescriptionRef,
      format: movieFormatRef,
      director: movieDirectorRef,
      roomId: selectedRoom.id,
      projections: selectedProjection,
    };


    MoviesService.editMovie(movie);
      
  };

  if (!movie) return null;

  return (
    <div className="container">
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Title: </Form.Label>
          <Form.Control
            type="text"
            id="title"
            ref={movieName}
            defaultValue={movie.name}
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Genre: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeGenre} id="genre" required>
            {genreItems.map((option, index) => (
              <option
                key={index}
                defaultValue={movie.genre}
                value={index}
              >
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
            id="releaseDate"
            ref={movieReleaseDate}
            defaultValue={movie.releaseDate}
            placeholder="Select the release date..."
            required
          />
        </Form.Group>
        <br />

        <Form.Group>
          <Form.Label>Duration: </Form.Label>
          <Form.Control
            type="number"
            id="duration"
            ref={movieDuration}
            defaultValue={movie.duration}
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
            defaultValue={movie.description}
            placeholder="Write the description of the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Format: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeFormat}  id="format" required>
            {formatItems.map((option, index) => (
              <option
                key={index}
                defaultValue={movie.format}
                value={index}
              >
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
            ref={movieDirector}
            defaultValue={movie.director}
            placeholder="Write a title..."
            id="director"
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
            {roomItems.map((option, index) => (
              <option key={index} value={JSON.stringify(option)}>
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
            id="projection"
          >
            {projectionItems.map((option, index) => (
              <option
                key={index}
                value={JSON.stringify(option)}
                ref={movieProjectionRef}
              >
                {option.date} {option.time}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Button variant="primary" type="submit"  id="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default EditMovie;
