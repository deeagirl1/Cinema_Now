import axios from "axios";
import authHeader from "./AuthHeader";

const TICKETS_API_BASE_URL = "http://localhost:8080/ticket";

class TicketService {
  getTickets() {
    return axios.get(TICKETS_API_BASE_URL, { headers: authHeader() });
  }
  createTicket(ticket) {
    return axios.post(TICKETS_API_BASE_URL, ticket, { headers: authHeader() });
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
