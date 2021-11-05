import React, { useEffect, useState } from "react";
import NewsService from "../Services/NewsService";
import "./NewsComponent.css";
function NewsComponent() {
    const [newsItems,setNews] = useState([]);

    useEffect(() => {
        getNews()
    }, [])

    const getNews = () => {
        NewsService.getNews().then((response) => {
            setNews(response.data);
            console.log(response.data);
        });
    }

    return(
        <div>
        <div  className = "news-item-container">
       {newsItems.map(
           news => 
         <div key={news.id}>
           <div className="title">{news.title}</div>
           <br/>
           <div className="description">{news.description}</div>
           <br/>
           <div className="date">{news.date}</div>
           </div>
        )}
        </div>
     </div>
    )
}

export default NewsComponent