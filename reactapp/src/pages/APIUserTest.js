import React from 'react';
import UserListComponent from '../components/Users/UsersComponent';
const News = () => {
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
      <h1>Users</h1>
  
    </div>
    <div className="container">
      
      <UserListComponent/>
    </div>
    </>  

  );
};

export default News;
