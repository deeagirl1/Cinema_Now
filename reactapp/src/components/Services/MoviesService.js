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
  createMovie(movie) {
    return axios.post(MOVIES_API_BASE_URL, movie, { headers: authHeader() });
  }
  getGenres() {
    return axios.get(MOVIES_API_BASE_URL + "/genres");
  }
  getFormats() {
    return axios.get(MOVIES_API_BASE_URL + "/formats");
  }
}
export default new MoviesService();
