import React from "react";
import { Card, Button } from "react-bootstrap";
import Grid from "@mui/material/Grid";
import { useHistory } from "react-router-dom";



function MovieItem(props) {
  const history = useHistory();
  const handleClick = (projectionId) => {
    const data = {
      movieId: props.movie.id,
      projectiondId: projectionId,
    };
    if (isLoggedIn === true)
    {
    history.push({
      pathname: "/buy-ticket",
      search: "?data=data",
      state: { data: data },
    });
    }
    else
    {
      history.push("/sign-in")
    }
  };

  let isLoggedIn= false;
  let user = localStorage.getItem('user');
  if(user !== null){
    isLoggedIn = true; 
  }
  else{
    isLoggedIn = false;
  }

  return (
    <>
      <Grid item key={props.movie.name} xs={10} sm={15} md={6}>
        <Card style={{ backgroundColor: "lightGray", width: "19rem" }}>
          <Card.Img variant="center" src={props.movie.movieImage} style = {{height: "400px"}} />
          <Card.Body>
            <Card.Title>{props.movie.name}</Card.Title>
            <Card.Text>
              {props.movie.description}
              <br />
              <br />
              Genre: {props.movie.genre} 
              <br/>
              Duration: {props.movie.duration} minutes 
              <br/>
               Format: {props.movie.format}
              <br />
              <br />
              Release date: {props.movie.releaseDate}
              <br />
              <br />
              Projections:
              <br />
              <div>
                {props.movie.projections.map((projection) => (
                  <><br /><Button
                    variant="primary"
                    onClick={() => {
                      handleClick(projection.id);
                    } }
                  >
                    {projection.date} {projection.time}
                  </Button><br /></>
                ))}
              </div>
            </Card.Text>
          </Card.Body>
        </Card>
      </Grid>
    </>
  );
}
export default MovieItem;
