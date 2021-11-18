import React from "react";
import MovieItem from "./MovieItem";
function MovieList(props){
    const handleDelete = (id) =>{
        props.onDelete(id);
    };

return(
    <ul>
        {props.movies.map((movie)=>(
            <MovieItem key = {movie.id} movie = {movie} onDelete = {handleDelete}></MovieItem>
        ))}
    </ul>
    )

}

export default MovieList;