import React from 'react';
import MoviePage from '../components/user..view/Movies/MoviePage';
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
      <h1>Movies</h1>
  
    </div>
    <div className="container">
      <MoviePage/>
    </div>
    </>  

  );
};


export default Schedule;
