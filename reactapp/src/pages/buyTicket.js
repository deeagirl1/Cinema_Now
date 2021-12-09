import React from 'react';
import TicketPage from '../components/Ticket/TicketForm';
const buyTicket = () => {
  return (
    <><div
      style={{
        display: 'flex',
        marginTop: '10px',
        justifyContent: 'center',
        alignItems: 'top',
        height: '10vh'
      }}
    >
    <div className="container">
       <TicketPage/>
      </div>
    </div>
      </>
  );
};

export default buyTicket;