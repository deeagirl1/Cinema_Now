import axios from "axios";
import authHeader from "./AuthHeader";

const PROJECTION_API_BASE_URL = "http://localhost:8080/projections";

class NewsService {
  getProjections() {
    return axios.get(PROJECTION_API_BASE_URL);
  }
  getProjectionsByMovie(movieId) {
    return axios.get(PROJECTION_API_BASE_URL, movieId, {
      headers: authHeader(),
    });
  }
  editProjection(projection) {
    return axios.put(PROJECTION_API_BASE_URL, projection, {
      headers: authHeader(),
    });
  }
  createProjection(projection) {
    return axios.post(PROJECTION_API_BASE_URL, projection, {
      headers: authHeader(),
    });
  }
  deleteProjection(projection) {
    return axios.delete(PROJECTION_API_BASE_URL, projection, {
      headers: authHeader(),
    });
  }
  getProjectionById(projectionId) {
    return axios.get(PROJECTION_API_BASE_URL + "/" + projectionId, {
      headers: authHeader(),
    });
  }
  getProjectionByMovieId(movieId) {
    return axios.get(PROJECTION_API_BASE_URL + "/" + movieId, {
      headers: authHeader(),
    });
  }
}

export default new NewsService();
