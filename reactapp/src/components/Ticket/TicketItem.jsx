import React from "react";
import { Card } from "react-bootstrap";

function TicketItem(props) {
  return (
    <>

      <Card>
        {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
        <Card.Body style={{ backgroundColor: "lightGray", borderRadius: "0%" }}>
          <Card.Text>
            {props.ticket.movieId}
            <br />
            <br />
            {props.ticket.price} {props.ticket.type}
            <br />
            <br />
          </Card.Text>
        </Card.Body>
      </Card>
      <br />
    </>
  );
}
export default TicketItem;
