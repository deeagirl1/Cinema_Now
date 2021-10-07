import React, { useEffect, useState } from "react";
import MoviesService from "../../Services/MoviesService";
import { Button } from "bootstrap";
import './MoviesComponent.css'

function MoviesComponent() {
  const [movieItems,setMovies] = useState([]);

  useEffect(() => {
      getMovies()
  }, [])

  const getMovies = () => {
         MoviesService.getMovies().then((response) => {
          setMovies(response.data);
          console.log(response.data);
      });
  }

   return(
    <div>
    <div  class = "movie-item-container">
   {movieItems.map(
       movie => 
     <div key={movie.id}>
            <div className="name">{movie.name}</div>
            <br/>
            <div className="genre">Genre: {movie.genre} | Duration: {movie.duration} | Format: {movie.format} </div>
            <br/>
            {/* <div className="duration">Duration: {movie.duration} minutes</div>
            <br/> */}
            <div className="release-date">Release date: {movie.releaseDate}</div>
            <br/>
            {/* <div className="format">Format: {movie.format}</div>
            <br/> */}
            <div className="description-item">Description:</div>
            <div className="description">{movie.description}</div>
      </div>
    )}
    </div>
 </div>
   )
}

export default MoviesComponent;


  
   

