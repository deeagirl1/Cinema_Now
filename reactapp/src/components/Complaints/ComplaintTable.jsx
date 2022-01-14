import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import ComplaintService from "../services/ComplaintService";

export default function ComplaintTable() {

  const [complaints, setComplaints] = useState([]);

  useEffect(() => {
    ComplaintService.getComplaints().then((response) => {
      setComplaints(response.data);
      console.log(response.data);
    });
  }, []);
  // eslint-disable-next-line
  complaints.map((complaint) => {
    // eslint-disable-next-line
     complaint["id"] = complaint.id;
  });

  
const columns = [
  { field: "title", headerName: "Title", flex: 1 },
  { field: "sentDate", headerName: "Sent on", flex: 1 },
  { field: "container", headerName: "Container", flex: 1 },
  { field: "sender", headerName: "Sender", flex: 1 },
];



return (
  <div style={{ height: 700, width: "flex" }}>

     <br /><DataGrid
      density="comfortable"
      rows={complaints}
      columns={columns}
      pageSize={5}
      rowsPerPageOptions={[5]}
      disableColumnSelector
      disableMultipleSelection={true}
      disableSelectionOnClick={true} />
    
  </div>
  );
}
