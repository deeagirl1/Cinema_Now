import React from 'react';
import QRCodeGenerator from '../components/user..view/Ticket/QRCodeGenerator';
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
       <QRCodeGenerator/>
      </div>
    </div>
      </>
  );
};

export default buyTicket;