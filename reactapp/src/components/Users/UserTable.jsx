import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import NotFound from "../PageNotFound";
import { IconButton } from "@mui/material";
import Delete from "@material-ui/icons/Delete";
import UserService from "../services/UserService";

const columns = [
  { field: "firstName", headerName: "First name", flex: 1 },
  { field: "lastName", headerName: "Last name", flex: 1 },
  { field: "loyal", headerName: "isLoyal", flex: 1 },
  { field: "email", headerName: "Email address", flex: 1 },

  {
    field: "Actions",
    flex: 1,
    renderCell: (cellValues) => {
      return (
        <div>
          <IconButton
            aria-label="delete"
            onClick={() => {
              handleClick(0, cellValues);
            }}
          >
            <Delete />
          </IconButton>
        </div>
      );
    },
  },
];

function handleClick(mode, selected) {
  switch (mode) {
    case 0:
      window.history.pushState({}, "", "/movie/" + selected.row.id);
      break;
    default:
      window.history.pushState(selected.row.id);
      break;
  }
}

export default function UserTable() {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    UserService.getUsers().then((response) => {
      setUsers(response.data);
      console.log(response.data);
    });
  }, []);

  users.map((user) => {
    user["id"] = user.id;
  });

  if (!users) return <NotFound />;

  return (
    <div style={{ height: 700, width: "flex" }}>
      <DataGrid
        density="comfortable"
        rows={users}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        disableColumnSelector
        disableMultipleSelection={true}
        disableSelectionOnClick={true}
      />
    </div>
  );
}
