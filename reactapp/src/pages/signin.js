import React from 'react';
import Login from '../components/signin_component'; 
const SignIn = () => {
  return (
    <div
    style={{
      display: 'flex',
      marginTop: '50px',
      justifyContent: 'center',
      alignItems: 'top',
      height: '10vh'
      }}
    >

      <div className="container">
       <Login/>
      </div>
    </div>
  );
};

export default SignIn;
