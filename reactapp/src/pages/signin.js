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
      <h1>Sign In</h1>
       <Login/>
      </div>
    </div>
  );
};

export default SignIn;
