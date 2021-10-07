import axios from 'axios'

const NEWS_API_BASE_URL = "http://localhost:8080/news";

class NewsService{
    getNews(){
        return axios.get(NEWS_API_BASE_URL);
    }
    createMovie(news){
        return axios.post(NEWS_API_BASE_URL, news);
    }
}

export default new NewsService()