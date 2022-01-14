import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";

const MOVIES_API_BASE_URL = "http://localhost:8080/movie";


const notificationSuccessful = {
  title: "Successful",
  message: "Success!",
  type: "success",
  insert: "top",
  container: "top-center",
  animationIn: ["animate__animated animate__fadeIn"],
  animationOut: ["animate__animated animate__fadeOut"],
  dismiss: {
    duration: 2500,
  },
};
const notificationUnSuccessful = {
  title: "Something went wrong!",
  message: "Please try again!",
  type: "danger",
  insert: "top",
  container: "top-center",
  animationIn: ["animate__animated animate__fadeIn"],
  animationOut: ["animate__animated animate__fadeOut"],
  dismiss: {
    duration: 1000,
  },
};

class MoviesService {
  async getMovies() {
    return await axios.get(MOVIES_API_BASE_URL);
  }
  async getMoviesById(movieID) {
    return await axios.get(MOVIES_API_BASE_URL + "/" + movieID, {
      headers: authHeader(),
    });
  }

  getMoviesByProjectionDate(date) {
    return axios.get(
      MOVIES_API_BASE_URL + "/projections" + { params: { date } },
      {
        headers: authHeader(),
      }
    );
  }
  async createMovie(movie) {
    try {
      const response = await axios.post(MOVIES_API_BASE_URL, movie, {
        headers: authHeader()});
      console.log(response);
        if (response.data !== null) {
          store.addNotification({
            ...notificationSuccessful,
            container: "top-center",
          });
          window.location.reload();
        }
      }
    
      catch (error) {
        store.addNotification({
          ...notificationUnSuccessful,
          container: "top-center",
        });
    }
  }
  getGenres() {
    return axios.get(MOVIES_API_BASE_URL + "/genres");
  }
  async editMovie(movie) {
    try {
      const response = await axios.put(MOVIES_API_BASE_URL, movie);
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        });
        console.log(response);
        window.location.reload();
      }
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    };
  }
  getFormats() {
    return axios.get(MOVIES_API_BASE_URL + "/formats");
  }

  getMoviesBasedOnGenre(genre) {
    return axios.get(MOVIES_API_BASE_URL + "/genre/" + genre);
  }
  async deleteMovie(id) {
    return await axios.delete(MOVIES_API_BASE_URL + "/" + id, {
      headers: authHeader(),
    });
  }
}
export default new MoviesService();
