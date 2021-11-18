import axios from 'axios'
import authHeader from './AuthHeader';

const ROOM_API_BASE_URL = "http://localhost:8080/rooms";

class RoomService{
    getRooms(){
        return axios.get(ROOM_API_BASE_URL);
    }
    getRoomById(roomId){
        return axios.get(ROOM_API_BASE_URL + '/' + roomId);
    }
    createRoom(room){
        return axios.post(ROOM_API_BASE_URL, room, {headers: authHeader()});
    }
    editRoom(room){
        return axios.post(ROOM_API_BASE_URL, room, {headers: authHeader()});
    }
    deleteRoom(room){
        return axios.post(ROOM_API_BASE_URL, room, {headers: authHeader()});
    }
    
}

export default new RoomService()