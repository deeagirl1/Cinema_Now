import React from 'react';
import MoviesComponent from '../components/Movies/MoviesComponent';
const Schedule = () => {
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
      <h1>Schedule</h1>
  
    </div>
    <div className="container">
      
      <MoviesComponent/>
    </div>
    </>  

  );
};


export default Schedule;
