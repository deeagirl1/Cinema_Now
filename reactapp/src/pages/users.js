import React from 'react';
import UserPage from '../components/Users/UsersPage';

const Users = () => {
  return (
    <><div
    style={{
        display: 'flex',
        marginTop: '10px',
        justifyContent: 'center',
        alignItems: 'center',
        height: '10vh'
      }}
    >
    </div>
    <div className="container">
      <UserPage/>

    </div>
    </>  

  );
};

export default Users;