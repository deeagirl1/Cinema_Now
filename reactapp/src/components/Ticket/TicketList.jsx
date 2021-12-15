import React from "react";
import TicketItem from "./TicketItem";
import Grid from "@mui/material/Grid";
import Container from "@mui/material/Container";
function TicketList(props) {
  return (
    <Container sx={{ py: 1 }} maxWidth="md">
      <Grid container spacing={5}>
        {props.tickets.map((ticket) => (
          <TicketItem key={ticket.id} movie={ticket}></TicketItem>
        ))}
      </Grid>
    </Container>
  );
}

export default TicketList;
