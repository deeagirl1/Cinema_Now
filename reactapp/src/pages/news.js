import React from 'react';
import NewsComponent from '../components//user..view/News/NewsComponent';
import Slider from '../components/user..view/Slider/Slider';

const News = () => {
  return (
    <><div
      style={{
        marginTop: '0px',
       
        alignItems: 'top',
      }}
    >
    </div>
    <div className="container">
      <Slider/>
      &nbsp;
      <h1>News</h1>
      <NewsComponent/>

    </div>
    </>  

  );
};

export default News;
