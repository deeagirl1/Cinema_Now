import axios from 'axios'
import authHeader from './AuthHeader';

const NEWS_API_BASE_URL = "http://localhost:8080/news";

class NewsService{
    getNews(){
        return axios.get(NEWS_API_BASE_URL);
    }
    createNewPost(post){
        return axios.post(NEWS_API_BASE_URL, post, {headers: authHeader()});
    }
    editPost(post){
        return axios.put(NEWS_API_BASE_URL, post, {headers: authHeader()});
    }
    deletePost(postId){
        return axios.delete(NEWS_API_BASE_URL + '/' + postId, {headers: authHeader()});
    }
    getPostById(postId)
    {
        return axios.get(NEWS_API_BASE_URL + '/' + postId, {headers: authHeader()});
    }
    
}

export default new NewsService()