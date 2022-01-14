import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";

const PROJECTION_API_BASE_URL = "http://localhost:8080/projections";

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


class NewsService {
  getProjections() {
    return axios.get(PROJECTION_API_BASE_URL);
  }
  getProjectionsByMovie(movieId) {
    return axios.get(PROJECTION_API_BASE_URL, movieId, {
      headers: authHeader(),
    });
  }
  async editProjection(projection) {
    try {
      const response = await axios.put(PROJECTION_API_BASE_URL, projection, {
        headers: authHeader(),
      });
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        });
      
      }
     
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    }
  }
  async createProjection(projection) {
    try {
      const response = await axios.post(PROJECTION_API_BASE_URL, projection, {
        headers: authHeader(),
      });
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        });
        
      }
      window.location.reload();
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    }
  }
  async deleteProjection(projection) {
    try {
      const response = await axios.delete(PROJECTION_API_BASE_URL + "/" + projection, {
        headers: authHeader(),
      });
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        });
      }
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    }
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
