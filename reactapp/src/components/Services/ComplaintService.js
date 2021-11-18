import axios from 'axios'
import authHeader from './AuthHeader';

const COMPLAINTS_API_BASE_URL = "http://localhost:8080/complaint";

class ComplaintService{
    getComplaints(){
        return axios.get(COMPLAINTS_API_BASE_URL, {headers: authHeader()});
    }
    createComplaint(complaint){
        return axios.post(COMPLAINTS_API_BASE_URL, complaint, {headers: authHeader()});
    }
    getComplaintById(complaintID){
        return axios.get(COMPLAINTS_API_BASE_URL + '/' + complaintID, {headers: authHeader()});
    }
    
}

export default new ComplaintService()