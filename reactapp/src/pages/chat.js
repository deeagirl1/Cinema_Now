import React from 'react';
import Chat from '../components/ChatComponents/Chat'; 
const SignIn = () => {
  return (
    <div
    style={{
      display: '-ms-inline-flexbox',
      marginTop: '50px',
      justifyContent: 'center',
      alignItems: 'top',
      height: '10vh'
      }}
    >
      <div className="container">
       <Chat/>
      </div>
    </div>
  );
};

export default SignIn;
