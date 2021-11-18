import axios from 'axios'
import authHeader from './AuthHeader';

const USERS_API_BASE_URL = "http://localhost:8080/user";

class UserService{
    getUsers(){
        return axios.get(USERS_API_BASE_URL, {headers: authHeader()});
    }
    getUserID(userID){
        return axios.get(USERS_API_BASE_URL + '/' + userID, {headers: authHeader()});
    }
    getUserByUsername(username)
    {
        return axios.get(USERS_API_BASE_URL + '/' + username, {headers: authHeader()});
    }
    editUser(user){
        return axios.post(USERS_API_BASE_URL, user, {headers: authHeader()});
    }
    deletePost(userId){
        return axios.post(USERS_API_BASE_URL, userId, {headers: authHeader()});
    }
    
}

export default new UserService()