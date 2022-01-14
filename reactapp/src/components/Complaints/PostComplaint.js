import { React, useEffect, useState, Fragment, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import AuthService from "../services/AuthService";
import ComplaintService from "../services/ComplaintService";
import moment from "moment";
import SignIn from "../signin_component";

var isLoggedIn = false;

if (AuthService.getCurrentUser() !== null) {
  isLoggedIn = true;
}

const PostComplaint = () => {


  const [user, setUser] = useState(null);

  useEffect(() => {
    const username = JSON.parse(localStorage.getItem("user"));

    if (username && username.user) {
      setUser(username.user);
    }
  }, []);

  const title = useRef();
  const container = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    const titleRef = title.current.value;
    const containerRef = container.current.value;

    const complaint = {
      title: titleRef,
      container: containerRef,
      sentDate: moment().format("DD/MM/YYYY"),
    };
    ComplaintService.createComplaint(complaint)
      
  };

  let menu = "";

  if (isLoggedIn === true) {
    menu = (
      <Fragment>
        <Form.Label>Username: </Form.Label> <br />
        <Form.Label>{user}</Form.Label>
      </Fragment>
    );
  }
  if (!user) {
    return <SignIn />;
  } else {
    return (
      <div>
        <br />
        <Form onSubmit={handleSubmit}>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            {menu}
          </Form.Group>
          <Form.Group>
            <Form.Label>Title </Form.Label>
            <Form.Control
              type="text"
              ref={title}
              id="title"
              placeholder="Write a title..."
              required
            />
          </Form.Group>
          <br />
          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>Your complaint:</Form.Label>
            <Form.Control
              as="textarea"
              ref={container}
              rows="3"
              id="container"
              name="complaint"
              placeholder="Write your complaint..."
              required
            />
          </Form.Group>
          <Button
            variant="primary"
            type="submit"
            id="submit"
            style={{ alignSelf: "center" }}
          >
            Submit
          </Button>
        </Form>
      </div>
    );
  }
};

export default PostComplaint;
