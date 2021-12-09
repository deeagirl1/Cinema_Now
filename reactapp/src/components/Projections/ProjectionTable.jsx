import React, { useState, useEffect } from "react";
import Delete from "@material-ui/icons/Delete";
import { IconButton } from "@mui/material";
import { Modal } from "react-bootstrap";
import AddIcon from "@mui/icons-material/Add";
import Edit from "@material-ui/icons/Edit";
import { DataGrid } from "@mui/x-data-grid";
import ProjectionService from "../services/ProjectionService";
import ProjectionForm from './ProjectionForm';

export default function NewsTable() {
  const [showProjection, setProjection] = useState(false);
  const handleCloseProjectionForm = () => setProjection(false);
  const handleShowProjectionForm = () => setProjection(true);

  const [projections, setProjections] = useState([]);

  useEffect(() => {
    ProjectionService.getProjections().then((response) => {
      setProjections(response.data);
      console.log(response.data);
    });
  }, []);

  projections.map((projection) => {
    projection["id"] = projection.id;
  });

  const columns = [
    { field: "date", headerName: "Date", flex: 1 },
    { field: "time", headerName: "Time", flex: 1 },
    {
      field: "Actions",
      flex: 1,
      renderCell: (cellValues) => {
        return (
          <div>
            <IconButton
              aria-label="edit"
              onClick={() => {
                handleClick(1, cellValues);
              }}
            >
              <Edit />
            </IconButton>
            <IconButton
              aria-label="delete"
              onClick={() => {
                handleClick(2, cellValues);
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
    ProjectionService.deleteProjection(id)
      .then((response) => {
        if (response.data !== null) {
          alert("Projection deleted succesfully.");
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
       <>
      <AddIcon variant="primary" onClick={handleShowProjectionForm}>
        Add projections
      </AddIcon>
      <Modal show={showProjection} onHide={handleCloseProjectionForm} aria-labelledby="example-modal-sizes-title-lg" size="lg">
        <Modal.Header closeButton>
          <Modal.Title>Movie information</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <ProjectionForm/>
        </Modal.Body>
      </Modal>
      </>
      <div style={{ height: 700, width: "flex" }}>
        <DataGrid
          density="comfortable"
          rows={projections}
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
