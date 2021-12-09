import axios from "axios";
import authHeader from "./AuthHeader";

const MOVIES_API_BASE_URL = "http://localhost:8080/movie";

class MoviesService {
  getMovies() {
    return axios.get(MOVIES_API_BASE_URL);
  }
  getMoviesById(movieID) {
    return axios.get(MOVIES_API_BASE_URL + "/" + movieID, {
      headers: authHeader(),
    });
  }

  getMoviesByProjectionDate(date) {
    return axios.get(MOVIES_API_BASE_URL + "/projections" + { params: {date}}, {
      headers: authHeader(),
    });
  }
  createMovie(movie) {
    return axios.post(MOVIES_API_BASE_URL, movie, { headers: authHeader() });
  }
  getGenres() {
    return axios.get(MOVIES_API_BASE_URL + "/genres");
  }
  editMovie(movie) {
    return axios.put(MOVIES_API_BASE_URL, movie);
  }
  getFormats() {
    return axios.get(MOVIES_API_BASE_URL + "/formats");
  }
  deleteMovie(id) {
    return axios.delete(MOVIES_API_BASE_URL + "/" + id, { headers: authHeader()});
  }

  
}
export default new MoviesService();
