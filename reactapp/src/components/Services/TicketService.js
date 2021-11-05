import axios from 'axios'

const TICKETS_API_BASE_URL = "http://localhost:8080/ticket";

class TicketService{
    getTickets(){
        return axios.get(TICKETS_API_BASE_URL);
    }
    createTicket(ticket){
        return axios.post(TICKETS_API_BASE_URL, ticket);
    }
    getTicketByID(ticketID){
        return axios.get(TICKETS_API_BASE_URL + '/' + ticketID);
    }
    
}

export default new TicketService()