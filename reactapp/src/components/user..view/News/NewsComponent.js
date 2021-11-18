import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import NewsService from "../../services/NewsService";
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
    return (
        <> {newsItems.map((news) => (
         <Card>
           {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
           <Card.Body key={news.id} style={{backgroundColor: 'lightGray', borderRadius: '0%'}}>
             <Card.Title>{news.title}</Card.Title>
             <br/>
             <Card.Text>
               {news.description}
             </Card.Text>
             <br/>
             <Card.Text>
             {news.postedAt}
             </Card.Text>
           </Card.Body>
         </Card>
         ))}</> 
         );

  
}

export default NewsComponent