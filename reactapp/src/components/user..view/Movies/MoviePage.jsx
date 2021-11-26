import { React, useState, useEffect } from "react";
import AuthService from "../../services/AuthService";
import MoviesService from "../../services/MoviesService";
import MovieList from "./MovieList";
import MovieForm from "./MoviesForm";

function MoviePage() {
  const [movies, setMovies] = useState(null);
  
  useEffect(() => {
    MoviesService.getMovies().then((response) => {
      console.log(response.data);
      setMovies(response.data);
    });
  
   }, []);

  function deleteMovie(id) {
    const newMovies = [...movies];
    const index = newMovies.indexOf(id);
    newMovies.splice(index, 1);
    MoviesService.deleteMovie(id);
    setMovies(newMovies);
  }

  if (!movies) 
    return null;
  
  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          <MovieForm/>
        )}
      {AuthService.getCurrentUser() === null && (
        <MovieList movies={movies} onDelete={deleteMovie}></MovieList>
      )}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
          <MovieList movies={movies} onDelete={deleteMovie}></MovieList>
        )}
    </div>
  );
}

export default MoviePage;
