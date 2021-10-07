import React from 'react';
import NewsComponent from '../components/News/NewsComponent';
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
      <h1>News</h1>
  
    </div>
    <div className="container">
      
      <NewsComponent/>
    </div>
    </>  

  );
};

export default News;
