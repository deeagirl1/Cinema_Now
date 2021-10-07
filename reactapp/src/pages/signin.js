import React from 'react';
import Login from '../components/SignIn/SignIn'; 
const SignIn = () => {
  return (
    <div
    style={{
      display: 'flex',
      marginTop: '10px',
      justifyContent: 'center',
      alignItems: 'top',
      height: '5vh'
      }}
    >
      <Login/>
    </div>
  );
};

export default SignIn;
