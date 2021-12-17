import { React, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import ProjectionService from "../services/ProjectionService";

const PostRoom = () => {
  const projectionTime = useRef();
  const projectionDate = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    const projectionTimeRef = projectionTime.current.value;
    const projectionDateRef = projectionDate.current.value;

    const projection = {
      date: projectionDateRef,
      time: projectionTimeRef,
    };

    ProjectionService.createProjection(projection)
      .then((response) => {
        if (response.data !== null) {
          alert("Projection added succesfully.");
        }
      })
      .catch(() => {
        <div className="alert alert-danger" role="alert">
          Houston, we have a problem! Please try again.
        </div>;
      });
    window.location.reload();
  };

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Projection date: </Form.Label>
          <Form.Control
            type="text"
            ref={projectionDate}
               id="projectionDate"
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Projection time: </Form.Label>
          <Form.Control
            type="text"
            ref={projectionTime}
            placeholder="Write the maximum capacity of the room..."
            required
          />
        </Form.Group>
        <br />
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostRoom;
