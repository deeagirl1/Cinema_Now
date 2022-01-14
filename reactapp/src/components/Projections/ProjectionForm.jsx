import { React, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import ProjectionService from "../services/ProjectionService";
const PostProjection = () => {
  
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
            placeholder="Write a date for the projection..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Projection time: </Form.Label>
          <Form.Control
            type="text"
            ref={projectionTime}
            id="projectionTime"
            placeholder="Write the time for the projection..."
            required
          />
        </Form.Group>
        <br />
        <Button variant="primary" type="submit" id="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostProjection;
