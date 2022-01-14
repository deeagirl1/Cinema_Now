import { React, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import RoomService from "../services/RoomService";

const PostRoom = () => {

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

    RoomService.createRoom(room);
 
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
            id="roomNumber"
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
            id="capacity"
            placeholder="Write the maximum capacity of the room..."
            min="0"
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

export default PostRoom;
