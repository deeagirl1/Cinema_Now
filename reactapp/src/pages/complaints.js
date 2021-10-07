import React from 'react';
import ComplaintListComponent from '../components/Complaints/ComplaintListComponent';
const Complaints = () => {
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
      <h1>Complaints</h1>
    </div><div className="container">

        <ComplaintListComponent/>
      </div></>
 
  );
};

export default Complaints;
