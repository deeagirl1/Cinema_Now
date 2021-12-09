import * as React from "react";
import { DataGrid } from "@mui/x-data-grid";
import { useEffect, useState } from "react";
import MovieService from "../services/MoviesService";
import NotFound from "../PageNotFound";
import { IconButton } from "@mui/material";
import Edit from "@material-ui/icons/Edit";
import Delete from "@material-ui/icons/Delete";
import { Button } from "react-bootstrap";
import MovieForm from "./MoviesForm";
import ProjectionForm from "./ProjectionForm";
import {Modal} from "react-bootstrap";
import AddIcon from '@mui/icons-material/Add';

export default function MovieTable(props) {
  const [showMovie, setShowMovie] = useState(false);
  const handleCloseMovieForm = () => setShowMovie(false);
  const handleShowMovieForm = () => setShowMovie(true);

  const [movies, setMovies] = useState([]);

  const handleDelete = (id) => {
    MovieService.deleteMovie(id).then((response) => {
      if (response.data !== null) {
       alert("Movie deleted succesfully.");
       window.location.reload();
      }
    })
    .catch(() => {
      <div className="alert alert-danger" role="alert">
        Houston, we have a problem! Please try again.
      </div>;
    });
  }
 
  useEffect(() => {
    getAllMovies();
  }, []);

  const getAllMovies = () => {
    MovieService.getMovies().then((response) => {
      setMovies(response.data);
    });
  };

  movies.map((movie) => {
    movie["id"] = movie.id;
  });

  

  const columns = [
    { field: "name", headerName: "Movie Name", flex: 1 },
    { field: "releaseDate", headerName: "Release Date", flex: 1 },
    { field: "description", headerName: "Description", flex: 1 },
    // {
    //   field: "projections.date",
    //   headerName: "Dates of projection",
    //   flex: 1,
    //   renderCell: (cellValues) => {
    //     return (
    //       <div>
    //           {movies.map((option, index) => (
    //             <option value={JSON.stringify(option.projections.date)}>
    //             {option.projections[index].date}
    //           </option>
    //         ))}
    //       </div>
    //     );
    //   },
    // },
    // {
    //   field: "time",
    //   headerName: "Time",
    //   flex: 1,
    //   renderCell: (cellValues) => {
    //     return (
    //       <div>
    //         <select as="select" required>
    //         <option value=""> -- Select a genre -- </option>
    //           {movies.map((option, index) => (
    //             <option key={index} value={JSON.stringify(option)}>
    //             {option.projections[index].time}
    //           </option>
    //         ))}
    //         </select>
    //       </div>
    //     );
    //         },
    // },
    {
      field: "Actions",
      flex: 1,
      renderCell: (cellValues) => {
        return (
          <div>
            <IconButton
              aria-label="edit"
              onClick={() => {
                handleClick(0, cellValues)
              
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

  function handleClick(mode, selected) {
    switch (mode) {
      case 0:
          
        window.history.pushState({}, '', "/editMovie/"+selected.row.id);
        window.location.replace("/editMovie/"+selected.row.id);
        {console.log(selected.row.id)}
        break;

        case 1:
          handleDelete(selected.row.id);
    
          break;
      default:
 
        break;
    }
  }

 

  if (!movies) return <NotFound />;

  return (
    <div style={{ height: 700, width: "flex" }}>

        <>
          <AddIcon variant="primary" onClick={handleShowMovieForm}>
          </AddIcon>
          <Modal show={showMovie} onHide={handleCloseMovieForm} aria-labelledby="example-modal-sizes-title-lg" size="lg">
            <Modal.Header closeButton>
              <Modal.Title>Movie information</Modal.Title>
            </Modal.Header>
            <Modal.Body>
              <MovieForm />
            </Modal.Body>
          </Modal>
        </>
       <br /><DataGrid
        density="comfortable"
        rows={movies}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        disableColumnSelector
        disableMultipleSelection={true}
        disableSelectionOnClick={true} />
      
    </div>
  );
}
