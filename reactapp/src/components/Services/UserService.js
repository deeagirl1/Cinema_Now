import axios from 'axios'

const USERS_API_BASE_URL = "http://localhost:8080/user";

class UserService{
    getUsers(){
        return axios.get(USERS_API_BASE_URL);
    }
    createUser(user){
        return axios.post(USERS_API_BASE_URL, user);
    }
    getUserID(userID){
        return axios.get(USERS_API_BASE_URL + '/' + userID);
    }
    
}

export default new UserService()