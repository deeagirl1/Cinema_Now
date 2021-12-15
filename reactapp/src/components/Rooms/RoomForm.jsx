import { React, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import RoomService from "../services/RoomService";
import { store } from "react-notifications-component";

const PostRoom = () => {
  const notificationSuccessful = {
    title: "Successful",
    message: "Room added successfully!",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 2500,
    },
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
      duration: 1000,
    },
  };

  const roomName = useRef();
  const roomCapacity = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();

    const roomNameRef = roomName.current.value;
    const roomCapacityRef = roomCapacity.current.value;

    const room = {
      name: roomNameRef,
      capacity: roomCapacityRef,
    };

    RoomService.createRoom(room)
      .then((response) => {
        if (response.data !== null) {
          store.addNotification({
            ...notificationSuccessful,
            container: "top-center",
          });
        }
      })
      .catch(() => {
        store.addNotification({
          ...notificationUnSuccessful,
          container: "top-center",
        });
      });
    window.location.reload();
  };

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group>
          <Form.Label>Room number: </Form.Label>
          <Form.Control
            type="number"
            ref={roomName}
            min="0"
            placeholder="Write a title for the movie..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group>
          <Form.Label>Capacity: </Form.Label>
          <Form.Control
            type="number"
            ref={roomCapacity}
            placeholder="Write the maximum capacity of the room..."
            min="0"
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
