import { useState, useEffect } from "react";
import TicketService from "../services/TicketService";
import AuthService from "../services/AuthService";
import { Card } from "react-bootstrap";
import Grid from "@mui/material/Grid";

const UserTickets = () => {
  const [tickets, setTickets] = useState(null);
  const username = AuthService.getCurrentUser().user;

  useEffect(() => {
    TicketService.getTicketsOfUser(username).then((response) => {
      setTickets(response.data);
      console.log(response.data);
      
    });
  }, []) // eslint-disable-line react-hooks/exhaustive-deps

  if (!tickets) return <h1>You have no tickets :(</h1>;

  return (
    <>
      {tickets.map((ticket) => (
        <Grid item key={ticket.movieId} xs={5} sm={10} md={2}>
          <Card>
            {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
            <Card.Body
              style={{ backgroundColor: "lightGray", borderRadius: "0%" }}
            >
              <Card.Text>
                {ticket.movieId}
                <br />
                <br />
                {ticket.price} {ticket.type}
                <br />
                <br />
              </Card.Text>
            </Card.Body>
          </Card>
        </Grid>
      ))}
    </>
  );
};
export default UserTickets;
