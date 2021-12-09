import { useState, useEffect } from 'react';
import TicketService from "../services/TicketService";
import AuthService from "../services/AuthService";

 const UserTickets = () => {

 const [tickets,setTickets] = useState(null)
 const username = AuthService.getCurrentUser().user;
   
    useEffect(() => {  
      TicketService.getTicketsOfUser(username).then((response) => {
            setTickets(response.data);
            console.log(response.data);
        });
    }, [])    


    if(!tickets)
    return <h1>You have no tickets :(</h1>

  return (
      <div>
        <div class="complaint-item-container">
          {tickets.map((ticket) => (
            <div key={ticket.id}>
              <div className="title">{ticket.movieId}</div>
              <br />
              <div className="description">{ticket.price}</div>
              <br />
              <div className="sender">{ticket.type}</div>
            </div>
          ))}
        </div>
      </div>
  );
};

export default UserTickets;

