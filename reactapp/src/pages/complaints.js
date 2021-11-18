import React from "react";
import PostComplaint from "../components/user..view/Complaints/PostComplaint";

const Complaints = () => {
  return (
    <div
      style={{
        display: 'flex',
        marginTop: '10px',
        justifyContent: 'center',
        alignItems: 'top',
        height: '10vh'
      }}
    >
      <div className="container">
        <h1>Send a complaint!</h1>
        <PostComplaint/>
      </div>
    </div>
  );
};

export default Complaints;
