import React from 'react';
import ComplaintListComponent from '../components/user..view/Complaints/ComplaintListComponent';

const ReceivedComplaints = () => {
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
      <h1>Received complaints from clients</h1>
  
    </div>
    <div className="container">
      <ComplaintListComponent></ComplaintListComponent>
    </div>
    </>  

  );
};


export default ReceivedComplaints;