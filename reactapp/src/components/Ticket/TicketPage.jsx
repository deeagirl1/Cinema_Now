import { React, useState, useEffect } from "react";
import AuthService from "../services/AuthService";
import TicketForm from "./TicketForm";
import TicketService from "../services/TicketService";
import { Link } from "react-router-dom";
import NotFound from "../PageNotFound";


function TicketPage() {
  const [tickets, setTickets] = useState(null);

  useEffect(() => {
    TicketService.getTickets().then((response) => {
      console.log(response.data);
      setTickets(response.data);
    });
  }, []);

  if (!tickets) return <NotFound/>;

  return (
    <div className="container">
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          <>
            <div
              style={{
                display: "flex",
                marginTop: "10px",
                justifyContent: "center",
                alignItems: "top",
                height: "10vh",
              }}
            >
              <h1>News</h1>
            </div>
            <div className="container">
              <TicketForm />
            </div>
          </>
        )}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
          <>
            <TicketForm />
          </>
        )}

      {AuthService.getCurrentUser() === null && <Link to="/sign-in"></Link>}
    </div>
  );
}

export default TicketPage;
