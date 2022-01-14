import axios from "axios";
import authHeader from "./AuthHeader";

const USERS_API_BASE_URL = "http://localhost:8080/user";

class UserService {
  getUsers() {
    return axios.get(USERS_API_BASE_URL, { headers: authHeader() });
  }
  getUserByUsername(username) {
    return axios.get(USERS_API_BASE_URL + "/profile/" + username, {
      headers: authHeader(),
    });
  }
  async editUser(profile) {
    return await axios.put(USERS_API_BASE_URL, profile, { headers: authHeader() });
  }
  async deleteUser(userId) {
    return await axios.delete(USERS_API_BASE_URL, userId, { headers: authHeader() });
  }
}

export default new UserService();
