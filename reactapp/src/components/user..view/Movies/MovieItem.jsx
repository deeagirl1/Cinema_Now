import React from "react";
import { Card, Button} from "react-bootstrap";

function MovieItem(props) {
  return (
    <Card>
    {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
    <Card.Body style={{backgroundColor: 'lightGray', borderRadius: '0%'}}>
      <Card.Title>{props.movie.name}</Card.Title>
      <Card.Text>
        {props.movie.description}
        <br/><br/>
        Genre: {props.movie.genre} | Duration: {props.movie.duration} | Format: {props.movie.format}
        <br/><br/>
        Release date: {props.movie.releaseDate}
        <Button style={{float:'right'}} variant="primary">Buy a ticket!</Button>
      </Card.Text>
    </Card.Body>
  </Card>
  );
}
export default MovieItem;
