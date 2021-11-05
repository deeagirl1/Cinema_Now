import React from 'react';
import Register from '../components/SignIn/FormSignUp'
const SignUp = () => {
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
      <Register/>
    </div>
  );
};

export default SignUp;
