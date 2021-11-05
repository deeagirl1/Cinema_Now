import React from 'react';
import NewsComponent from '../components/News/NewsComponent';
import Slider from '../components/Slider/Slider';
const News = () => {
  return (
    <><div
      style={{
        marginTop: '0px',
        justifyContent: 'center',
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
