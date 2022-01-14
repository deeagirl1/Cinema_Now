import axios from "axios";
import authHeader from "./AuthHeader";
import { store } from "react-notifications-component";
const COMPLAINTS_API_BASE_URL = "http://localhost:8080/complaint";

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
class ComplaintService {
  getComplaints() {
    return axios.get(COMPLAINTS_API_BASE_URL, { headers: authHeader() });
  }
  async createComplaint(complaint) {
    try {
      const response = await axios.post(COMPLAINTS_API_BASE_URL, complaint, {
        headers: authHeader(),
      });
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
  getComplaintById(complaintID) {
    return axios.get(COMPLAINTS_API_BASE_URL + "/" + complaintID, {
      headers: authHeader(),
    });
  }
}

export default new ComplaintService();
