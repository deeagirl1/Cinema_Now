import React from "react";
import MovieItem from "./MovieItem";
import Grid from '@material-ui/core/Grid';
import Container from '@mui/material/Container';

function MovieList(props) {

  return (

    <>
    <Container sx={{ py: 1 }} maxWidth="md">
        <Grid container spacing={5}>
          {props.movies.map((movie) => (
            <MovieItem
              key={movie.id}
              movie={movie}
            ></MovieItem>
          ))}

        </Grid>
      </Container></>
  );
}

export default MovieList;
