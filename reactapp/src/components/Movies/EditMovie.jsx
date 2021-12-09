import { React, useRef, useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import MoviesService from "../services/MoviesService";
import RoomService from "../services/RoomService";
import ProjectionService from "../services/ProjectionService";
import { store } from "react-notifications-component";


const EditMovie = () => {

  const notificationSuccessful = {
    title: "Successful!",
    message: "Movie edited successfully",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 2500
    }
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
      duration: 1000
    }
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

      setProjection(response.data);
    });
  }, []);

  let param = window.location.pathname;  
  let id = param.split('/').pop();
  
  const [movie,setMovie] = useState(null);
  useEffect(() => {
    MoviesService.getMoviesById(id).then((response) => {
      console.log(response.data);
      setMovie(response.data);
    });
  }, [id]);

  const handleChangeGenre = (e) => {
    let obj = e.target.value; //genre object
    console.log(obj);
    setSelectedGenre(obj);
  };
  const handleChangeFormat = (e) => {
    let obj = e.target.value; //format object
    console.log(obj);
    setSelectFormats(obj);
  };
  const handleChangeRoom = (e) => {
    let obj = e.target.value; //format object
    console.log(obj);
    setSelectedRoom(JSON.parse(obj));
  };
  const handleChangeProjection = (e) => {
    let obj = e.target.value; //format object
    console.log(obj);
    setSelectedProjection(JSON.parse(obj));
  };


  const movieName = useRef();
  const movieDuration = useRef();
  const movieReleaseDate = useRef();
  const movieDescription = useRef();
  const movieDirector = useRef();


  const handleSubmit = (e) => {
    e.preventDefault();

    const enteredMovieName = movieName.current.value;
    const movieGenreRef =  selectedGenre;
    const movieDurationRef = movieDuration.current.value;
    const movieReleaseDateRef = movieReleaseDate.current.value;
    const movieDescriptionRef = movieDescription.current.value;
    const movieFormatRef =  selectedFormats;
    const movieDirectorRef = movieDirector.current.value;
    const movieRoomRef = selectedRoom.id;
    const movieProjectionRef = selectedProjection;
    
    // console.log(movieRoomRef);

    const movie = {
      id : id,
      name: enteredMovieName,
      genre: movieGenreRef,
      duration: movieDurationRef,
      releaseDate: movieReleaseDateRef,
      description: movieDescriptionRef,
      format: movieFormatRef,
      director: movieDirectorRef,
      roomId: movieRoomRef,
      projections: [
        {
          id: movieProjectionRef.id,
          date: movieProjectionRef.date,
          time: movieProjectionRef.time
     
        }
      ],
    };

    console.log(movie);

    MoviesService.editMovie(movie).then((response) => {
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: 'top-center'
          })
        window.location.reload();
      }
    })
    .catch(() => {
      store.addNotification({
        ...notificationUnSuccessful,
        container: 'top-center'
        })
    });
  
   
  };

  
  if(!movie) return null;

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Title: </Form.Label>
          <Form.Control
            type="text"
            ref={movieName}
            defaultValue = {movie.name}
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Genre: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeGenre} required>
          <option value=""> -- Select a genre -- </option>
            {genreItems.map((option, index) => (
              <option key={index}  defaultValue = {movie.genre}
              value = {JSON.stringify(index)}>
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
            defaultValue = {movie.releaseDate}
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
            defaultValue = {movie.duration}
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
            ref={movieDescription}
            defaultValue = {movie.description}
            placeholder="Write the description of the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Format: </Form.Label>
          <br />
          <Form.Control as="select" onChange={handleChangeFormat} required>
          <option value=""> -- Select a format -- </option>
            {formatItems.map((option, index) => (
              <option key={index}  defaultValue = {movie.format}   value = {JSON.stringify(index)}>
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
            defaultValue = {movie.director}
            placeholder="Write a title..."
            required
          />
        </Form.Group>
        <Form.Group>
          <Form.Label>Room: </Form.Label>
          <br />
          <select  onChange={handleChangeRoom} required id="room">
          <option value=""> -- Select a room -- </option>
            {roomItems.map((option, index) => (
              <option
                key={index}
                defaultValue = {movie.room}
                value = {JSON.stringify(option)}
               
              >
                {option.name}
              </option>
            ))}
          </select>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Projection: </Form.Label>
          <br />
          <select onChange={handleChangeProjection}  id="projection">
          <option value=""> -- Select a projection -- </option>
            {projectionItems.map((option, index) => (
              <option
                key={index}
                defaultValue = {movie.projection}
                value = {JSON.stringify(option)}
              >
                {option.date} {option.time}
              </option>
            ))}
          </select>
        </Form.Group>
        <br />
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default EditMovie;
