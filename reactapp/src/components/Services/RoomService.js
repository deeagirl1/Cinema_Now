import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";

const ROOM_API_BASE_URL = "http://localhost:8080/rooms";

const notificationSuccessful = {
  title: "Successful",
  message: "Success!",
  type: "success",
  insert: "top",
  container: "top-center",
  animationIn: ["animate__animated animate__fadeIn"],
  animationOut: ["animate__animated animate__fadeOut"],
  dismiss: {
    duration: 2500,
  },
};
const notificationUnSuccessful = {
  title: "Something went wrong!",
  message: "Please try again!",
  type: "danger",
  insert: "top",
  container: "top-center",
  animationIn: ["animate__animated animate__fadeIn"],
  animationOut: ["animate__animated animate__fadeOut"],
  dismiss: {
    duration: 1000,
  },
};

class RoomService {
  getRooms() {
    return axios.get(ROOM_API_BASE_URL);
  }
  getRoomById(roomId) {
    return axios.get(ROOM_API_BASE_URL + "/" + roomId);
  }
  async createRoom(room) {
    try {
      const response = await axios.post(ROOM_API_BASE_URL, room, { headers: authHeader() });
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        });
      }
      window.location.reload();
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    }
  
  }
  async editRoom(room) {
    try {
      const response = await axios.put(ROOM_API_BASE_URL, room, { headers: authHeader() });
      if (response.data !== null) {
        store.addNotification({
          ...notificationSuccessful,
          container: "top-center",
        
        },
        window.location.reload()
        );
      }
    } catch {
      store.addNotification({
        ...notificationUnSuccessful,
        container: "top-center",
      });
    }
  
  }
 async deleteRoom(room) {
  try {
    const response = await axios.delete(ROOM_API_BASE_URL + "/" + room, {
      headers: authHeader() });
    if (response.data !== null) {
      store.addNotification({
        ...notificationSuccessful,
        container: "top-center",
      
      },
      window.location.reload()
      );
    }
  } catch {
    store.addNotification({
      ...notificationUnSuccessful,
      container: "top-center",
    });
  }
  }

}

export default new RoomService();
