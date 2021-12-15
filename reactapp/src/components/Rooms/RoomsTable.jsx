import React, { useState, useEffect } from "react";
import RoomService from "../services/RoomService";
import Delete from "@material-ui/icons/Delete";
import { IconButton } from "@mui/material";
import { Modal } from "react-bootstrap";
import RoomForm from "./RoomForm";
import AddIcon from "@mui/icons-material/Add";
import Edit from "@material-ui/icons/Edit";
import { DataGrid } from "@mui/x-data-grid";

export default function NewsTable() {
  const [showRoom, setShowRoom] = useState(false);
  const handleCloseRoomForm = () => setShowRoom(false);
  const handleShowRoomForm = () => setShowRoom(true);

  const [rooms, setRooms] = useState([]);

  useEffect(() => {
    RoomService.getRooms().then((response) => {
      setRooms(response.data);
      console.log(response.data);
    });
  }, []);

  rooms.map((room) => {
     room["id"] = room.id;
  });

  const columns = [
    { field: "name", headerName: "Title", flex: 1 },
    { field: "capacity", headerName: "Description", flex: 1 },
    { field: "capacity", headerName: "NrOfTickets", flex: 1 },

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

  const handleDelete = (id) => {
    RoomService.deleteRoom(id)
      .then((response) => {
        if (response.data !== null) {
          alert("Room deleted succesfully.");
          window.location.reload();
        }
      })
      .catch(() => {
        <div className="alert alert-danger" role="alert">
          Houston, we have a problem! Please try again.
        </div>;
      });
  };

  function handleClick(mode, selected) {
    switch (mode) {
      case 0:
        break;
      case 1:
        handleDelete(selected.row.id);

        break;
      default:
        window.history.pushState(selected.row.id);
        break;
    }
  }

  return (
    <>
      <AddIcon variant="primary" onClick={handleShowRoomForm}></AddIcon>
      <Modal
        show={showRoom}
        onHide={handleCloseRoomForm}
        aria-labelledby="example-modal-sizes-title-lg"
        size="lg"
      >
        <Modal.Header closeButton>
          <Modal.Title>Room information</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <RoomForm />
        </Modal.Body>
      </Modal>
      <div style={{ height: 700, width: "flex" }}>
        <DataGrid
          density="comfortable"
          rows={rooms}
          columns={columns}
          pageSize={5}
          rowsPerPageOptions={[5]}
          disableColumnSelector
          disableMultipleSelection={true}
          disableSelectionOnClick={true}
        />
      </div>
    </>
  );
}
