import axios from 'axios'

const MOVIES_API_BASE_URL = "http://localhost:8080/movies";

class MoviesService{
    getMovies(){
        return axios.get(MOVIES_API_BASE_URL);
    }
    getMoviesById(movieID){
        return axios.get(MOVIES_API_BASE_URL + '/' + movieID);
    }
    createMovie(movie){
        return axios.post(MOVIES_API_BASE_URL, movie);
    }
    
}

export default new MoviesService()