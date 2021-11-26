import React, { useEffect, useState } from "react";
import ComplaintService from "../../services/ComplaintService";
import './ComplaintListComponent.css';

function ComplaintListComponent(){
    const [complaints,setComplaints] = useState([]);

    useEffect(() => {
        getComplaints()
    }, [])

    const getComplaints = () => {
        ComplaintService.getComplaints().then((response) => {
            setComplaints(response.data);
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

    //  return(
    //     <div>
    //     <div  class = "complaint-item-container">
    //    {complaints.map(
    //        complaint => 
    //      <table className="table" key={complaint.id}>
    //                 <thead>
    //                     <tr>
    //                     <th>Start</th>
    //                     <th>Destination</th>
    //                     <th>Date</th>
    //                     <th>Price</th>
    //                     <th>Apply!</th>
    //                     </tr>
    //                 </thead>
    //                 <tbody id="content">
    //                 </tbody>
    //      </table>
           
    //    )}
    //    </div>
    //    </div>
    // )
}

export default ComplaintListComponent;