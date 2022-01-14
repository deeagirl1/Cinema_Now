import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";

const NEWS_API_BASE_URL = "http://localhost:8080/news";

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
  getNews() {
    return axios.get(NEWS_API_BASE_URL);
  }
  async createNewPost(post) {
    try {
      const response = await axios.post(NEWS_API_BASE_URL, post, { headers: authHeader() });
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
    };
  }
  async editPost(post) {
    try {
      const response = await axios.put(NEWS_API_BASE_URL, post, { headers: authHeader() });
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
    };
  }
  deletePost(postId) {
    return axios.delete(NEWS_API_BASE_URL + "/" + postId, {
      headers: authHeader(),
    });
  }
  getPostById(postId) {
    return axios.get(NEWS_API_BASE_URL + "/" + postId, {
      headers: authHeader(),
    });
  }
}

export default new NewsService();
