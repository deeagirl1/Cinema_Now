import React from "react";
import { Card, Button} from "react-bootstrap";
import img from './pictures/img1.jpg';
import Grid from '@mui/material/Grid';
import { useHistory } from "react-router-dom";


function MovieItem(props) {

  const history = useHistory();
  const handleClick = (projectionId) => {
    const data = {
      movieId : props.movie.id,
      projectiondId : projectionId
    }
    history.push({
      pathname: "/buyTicket",
      search : '?data=data',
      state: {data: data}
    })
  }

  return (
    <>
    <Grid item key={props.movie.name} xs={10} sm={15} md={6}>
    <Card style={{backgroundColor: 'lightGray', width: '18rem'} }>
    <Card.Img variant="center" src={img}/>
    <Card.Body>
      <Card.Title>{props.movie.name}</Card.Title>
      <Card.Text>
        {props.movie.description}
        <br/><br/>
        Genre: {props.movie.genre} | Duration: {props.movie.duration} minutes | Format: {props.movie.format}
        <br/><br/>
        Release date: {props.movie.releaseDate}
        <br/><br/>
        Projections: 
        <br/>
        {
        props.movie.projections.map(projection => (
        <Button variant="primary" onClick = {() => {handleClick(projection.id)}}> {projection.date}  {projection.time}</Button>
       ))}
      </Card.Text>
    </Card.Body>
  </Card>
  </Grid></>
  
  // /${projection.id}
  );
}
export default MovieItem;

