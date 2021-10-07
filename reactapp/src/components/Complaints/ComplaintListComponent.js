import React, { useEffect, useState } from "react";
import ComplaintService from "../../Services/ComplaintService";
import './ComplaintListComponent.css';

function ComplaintListComponent(){
    const [complaints,setComplaint] = useState([]);

    useEffect(() => {
        getComplaints()
    }, [])

    const getComplaints = () => {
        ComplaintService.getComplaints().then((response) => {
            setComplaint(response.data);
            console.log(response.data);
        });
    }

    return(
        <div>
        <div  class = "complaint-item-container">
       {complaints.map(
           complaint => 
         <div key={complaint.id}>
           <div className="title">{complaint.title}</div>
           <br/>
           <div className="description">{complaint.container}</div>
           <br/>
           <div className="sender">{complaint.sender}</div>
           </div>
       )}
        </div>
     </div>
    )
}

export default ComplaintListComponent;