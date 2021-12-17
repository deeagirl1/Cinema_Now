import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import { IconButton } from "@mui/material";
import Edit from "@material-ui/icons/Edit";
import Delete from "@material-ui/icons/Delete";
import ComplaintService from "../services/ComplaintService";

export default function ComplaintTable() {

  const [complaints, setComplaints] = useState([]);

  useEffect(() => {
    ComplaintService.getComplaints().then((response) => {
      setComplaints(response.data);
      console.log(response.data);
    });
  }, []);

  complaints.map((complaint) => {
     complaint["id"] = complaint.id;
  });

  
const columns = [
  { field: "title", headerName: "Title", flex: 1 },
  { field: "sentDate", headerName: "Sent on", flex: 1 },
  { field: "container", headerName: "Container", flex: 1 },
  { field: "sender", headerName: "Sender", flex: 1 },

  {
    field: "Actions",
    flex: 1,
    renderCell: (cellValues) => {
      return (
        <div>
          <IconButton
            aria-label="edit"
            onClick={() => {
              handleClick(0, cellValues);
            }}
          >
            <Edit />
          </IconButton>
          <IconButton
            aria-label="delete"
            onClick={() => {
              handleClick(1, cellValues);
            }}
          >
            <Delete />
          </IconButton>
        </div>
      );
    },
  },
];

// const handleDelete = (id) => {
//   ComplaintService.deletePost(id).then((response) => {
//     if (response.data !== null) {
//      alert("Post deleted succesfully.");
//      window.location.reload();
//     }
//   })
//   .catch(() => {
//     <div className="alert alert-danger" role="alert">
//       Houston, we have a problem! Please try again.
//     </div>;
//   });
// }



function handleClick(mode, selected) {
  switch (mode) {
    case 0:
      break;
      case 1:
        // handleDelete(selected.row.id);
  
        break;
    default:
      window.history.pushState(selected.row.id);
      break;
  }
}

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
