import axios from 'axios'

const COMPLAINTS_API_BASE_URL = "http://localhost:8080/complaint";

class ComplaintService{
    getComplaints(){
        return axios.get(COMPLAINTS_API_BASE_URL);
    }
    createMovie(complaint){
        return axios.post(COMPLAINTS_API_BASE_URL, complaint);
    }
    getComplaintById(complaintID){
        return axios.get(COMPLAINTS_API_BASE_URL + '/' + complaintID);
    }
    
}

export default new ComplaintService()