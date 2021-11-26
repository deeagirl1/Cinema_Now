
import { React, useRef, useState, useEffect } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import MoviesService from "../../services/MoviesService";

const PostMovie = () => {
  const [genreItems, setGenre] = useState([]);
  const [selectedGenre,setSelectedGenre] = useState([]);

  const [formatItems, setFormats] = useState([]);
  const [selectedFormats,setSelectFormats] = useState([]);

   useEffect(() => {
    MoviesService.getGenres().then((response) => {
      console.log(response.data);
      setGenre(response.data);
    });
  }, []);

  useEffect(() => {
    MoviesService.getFormats().then((response) => {
      console.log(response.data);
      setFormats(response.data);
    });
  }, []);


  const movieName = useRef();
  const movieGenre = useRef();
  const movieDuration = useRef();
  const movieReleaseDate = useRef();
  const movieDescription = useRef();
  const movieFormat = useRef();
  const movieDirector = useRef();

  const required = (value) => {
    if (!value) {
      return (
        <div className="alert alert-danger" role="alert">
          This field is required!
        </div>
      );
    }
  };


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

  const handleSubmit = (e) => {
    e.preventDefault();

    const movieNameRef = movieName.current.value;
    const movieGenreRef = movieGenre.current.value;
    const movieDurationRef = movieDuration.current.value;
    const movieReleaseDateRef = movieReleaseDate.current.value;
    const movieDescriptionRef = movieDescription.current.value;
    const movieFormatRef = movieFormat.current.value;
    const movieDirectorRef = movieDirector.current.value;
    // const movieRoomRef = movieRoom.current.value;

    const movie = {
      name: movieNameRef,
      genre: movieGenreRef,
      duration: movieDurationRef,
      releaseDate: movieReleaseDateRef,
      description: movieDescriptionRef,
      format: movieFormatRef,
      director: movieDirectorRef,
      // room: movieRoomRef,
    };
    console.log(movie);
    MoviesService.createMovie(movie);
  };

  if (!genreItems) return null;

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Title: </Form.Label>
          <Form.Control
            type="text"
            ref={movieName}
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
        <Form.Label>Genre: </Form.Label>
        <br/>
          <Form.Control as="select" onChange={handleChangeGenre} required>
            <option value=""> -- Select a genre -- </option>
            {genreItems.map((option, index) => (
              <option key={index} value={option} ref={movieGenre}>
                {option}
              </option>
            )
            )
            }
          </Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Release Date: </Form.Label>
          <Form.Control type="text" ref={movieReleaseDate} placeholder="Select the release date..."  required />
        </Form.Group>
        <br />
   
        <Form.Group>
          <Form.Label>Duration: </Form.Label>
          <Form.Control type="number" ref={movieDuration} placeholder="Write the duration of the movie in minutes..." min="0" required />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Description: </Form.Label>
          <Form.Control type="text" ref={movieDescription} placeholder="Write the description of the movie..."  required />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Format: </Form.Label>
          <br/>
          <Form.Control as="select" onChange={handleChangeFormat}  required>
            <option value=""> -- Select a format  -- </option>
            {formatItems.map((option, index) => (
              <option key={index} value={option} ref={movieFormat}  >
                {option}
              </option>
            ))}
          </Form.Control>
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Director: </Form.Label>
          <Form.Control type="text" ref={movieDirector}  placeholder="Write a title..."  required />
        </Form.Group>
        <br />
        {/* <Form.Group>
        <select onChange={handleChangeFormat} required>
            <option value=""> -- Select a room  -- </option>
            {formatItems.map((option, index) => (
              <option key={index} value={option} ref={movieFormat}  >
                {option}
              </option>
            ))}
          </select>
          </Form.Group>
          <br /> */}
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostMovie;
