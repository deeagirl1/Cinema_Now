import { React, useRef  } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import ProjectionService from "../services/ProjectionService";
import { store } from "react-notifications-component";
const PostProjection = () => {
 
  const notificationSuccessful = {
    title: "Successful", 
    message: "Projection added successfully!",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 2500
    }
  };
  const notificationUnSuccessful = {
    title: "Something went wrong!",
    message: "Please try again!",
    type: "danger",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 1000
    }
  };

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

    ProjectionService.createProjection(projection).then((response) => {
        if (response.data !== null) {
          store.addNotification({
            ...notificationSuccessful,
            container: 'top-center'
            })
        }
      })
      .catch(() => {
        store.addNotification({
          ...notificationUnSuccessful,
          container: 'top-center'
          })
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

            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br/>
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

export default PostProjection;
