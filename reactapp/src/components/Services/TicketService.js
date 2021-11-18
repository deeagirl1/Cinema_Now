import axios from 'axios'

const TICKETS_API_BASE_URL = "http://localhost:8080/ticket";

class TicketService{
    getTickets(){
        return axios.get(TICKETS_API_BASE_URL, {headers: authHeader()});
    }
    createTicket(ticket){
        return axios.post(TICKETS_API_BASE_URL, ticket, {headers: authHeader()});
    }
    getTicketByID(ticketID){
        return axios.get(TICKETS_API_BASE_URL + '/' + ticketID, {headers: authHeader()});
    }
    
}

export default new TicketService()