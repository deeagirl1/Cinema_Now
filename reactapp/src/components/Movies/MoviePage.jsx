import { React, useState, useEffect } from "react";
import AuthService from "../services/AuthService";
import MoviesService from "../services/MoviesService";
import FilterMovies from "./FilterMovies";
import MovieList from "./MovieList";
import MovieTable from "./MovieTable";
function MoviePage() {
  
  const [movies, setMovies] = useState(null);

  useEffect(() => {
    MoviesService.getMovies().then((response) => {
      setMovies(response.data);
    });
  }, []);



  function filterMovie(genre)
  {
    console.log(genre);
    if(genre === "")
    {
      MoviesService.getMovies().then((response) => {
        setMovies(response.data);
      });
    }
    else
    {
      MoviesService.getMoviesBasedOnGenre(genre).then((response) => {
        setMovies(response.data);
      });
    }
  }

  if (!movies) return <h1>Currently, there are no movies.</h1>;

  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          // <><MovieForm /><br/></>

          <MovieTable />
        )}
      {AuthService.getCurrentUser() === null && (
        <><FilterMovies filterMovie={filterMovie}></FilterMovies>
        <br/>
        <MovieList movies={movies}></MovieList></>
      )}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
          <><FilterMovies filterMovie={filterMovie}></FilterMovies><MovieList movies={movies}></MovieList></>
        )}
    </div>
  );
}

export default MoviePage;
