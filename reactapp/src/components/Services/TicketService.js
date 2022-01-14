import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";

const TICKETS_API_BASE_URL = "http://localhost:8080/ticket";

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

class TicketService {
  getTickets() {
    return axios.get(TICKETS_API_BASE_URL, { headers: authHeader() });
  }
  async createTicket(ticket) {
    try {
      const response = await axios.post(TICKETS_API_BASE_URL, ticket, { headers: authHeader() });
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
  getTicketsOfUser(username) {
    return axios.get(TICKETS_API_BASE_URL + "/userTickets/" + username, {
      headers: authHeader(),
    });
  }
  getTicketTypes() {
    return axios.get(TICKETS_API_BASE_URL + "/ticketTypes", {
      headers: authHeader(),
    });
  }
  getTicketById(id) {
    return axios.get(TICKETS_API_BASE_URL + id, { headers: authHeader() });
  }
}

export default new TicketService();
