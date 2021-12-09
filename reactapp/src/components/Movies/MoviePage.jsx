import { React, useState, useEffect } from "react";
import NotFound from "../PageNotFound";
import AuthService from "../services/AuthService";
import MoviesService from "../services/MoviesService";
import MovieList from "./MovieList";
import MovieTable from "./MovieTable";
function MoviePage() {
  const [movies, setMovies] = useState(null);


  useEffect(() => {
    MoviesService.getMovies().then((response) => {
      setMovies(response.data);
    });
  }, []);

  if (!movies) return <NotFound/>;

  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          // <><MovieForm /><br/></>

          <MovieTable />
        )}
      {AuthService.getCurrentUser() === null && (

        <MovieList movies={movies}></MovieList>
      )}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
          <MovieList movies={movies}></MovieList>
        )}
    </div>
  );
}

export default MoviePage;
