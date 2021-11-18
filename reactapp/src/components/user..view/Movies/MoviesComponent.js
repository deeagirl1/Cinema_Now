import React, { useEffect, useState } from "react";
import { Card, Button} from "react-bootstrap";
import { useHistory } from "react-router";
import MoviesService from "../../services/MoviesService";

function MoviesComponent() {
  let history = useHistory();
  const redirect = () => {
    history.push("/buyTicket")
  }
  const [movieItems, setMovies] = useState([]);
  useEffect(() => {
    getMovies();
  }, []);

  const getMovies = () => {
    MoviesService.getMovies().then((response) => {
      setMovies(response.data);
      console.log(response.data);
    });
  };

  return (
   <> {movieItems.map((movie) => (
    <Card>
      {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
      <Card.Body key={movie.id} style={{backgroundColor: 'lightGray', borderRadius: '0%'}}>
        <Card.Title>{movie.name}</Card.Title>
        <Card.Text>
          {movie.description}
          <br/><br/>
          Genre: {movie.genre} | Duration: {movie.duration} | Format: {movie.format}
          <br/><br/>
          Release date: {movie.releaseDate}
          <Button style={{float:'right'}} variant="primary" onClick={redirect}>Buy a ticket!</Button>
        </Card.Text>
      </Card.Body>
    </Card>
    ))}</> 
  );
}

export default MoviesComponent;
