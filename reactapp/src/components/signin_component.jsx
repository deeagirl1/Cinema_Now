import React from "react";
import { Button, Form } from "react-bootstrap";
import { useHistory } from "react-router";
import AuthService from "./services/AuthService";

import "react-notifications-component/dist/theme.css";
import { store } from "react-notifications-component";

const SignIn = () => {
  const [msg, setMsg] = React.useState(null);
  const History = useHistory();
  const username = React.useRef();
  const password = React.useRef();

  const notificationSuccessful = {
    title: "Successful!",
    message: "You have been succesfully signed in!",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 1000,
    },
  };
  const notificationUnSuccessful = {
    title: "Something went wrong!",
    message: { msg },
    type: "danger",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 1000,
    },
  };

  const handleLogin = (e) => {
    e.preventDefault();
    if (username.current.value || password.current.value) {
      AuthService.login(username.current.value, password.current.value)
        .then((response) => response.json())
        .then((responseData) => {
          console.log(JSON.stringify(responseData));
          localStorage.setItem("user", JSON.stringify(responseData));
          store.addNotification({
            ...notificationSuccessful,
            container: "top-center",
          });
          History.push("/");
          window.location.reload();
        })
        .catch((_err) => {
          setMsg(_err);
          store.addNotification({
            ...notificationUnSuccessful,
            container: "top-center",
          });
        });
    }
  };

  return (
    <>
      <h1>Sign In</h1>
      <Form onSubmit={handleLogin}>
        <Form.Group className="mb-3" controlId="formBasicUsername">
          <Form.Label>Username</Form.Label>
          <Form.Control
            type="text"
            className="form-control"
            id="username"
            placeholder="Enter your username"
            ref={username}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            id="password"
            placeholder="Enter your password"
            ref={password}
          />
          <br />
        </Form.Group>
        <Button type="submit" className="btn btn-primary btn-block"  id="submit">
          Submit
        </Button>
        <br /> <br />
        <Form.Label className="forgot-password text-right">
          Forgot <a href="/reset-password">password?</a>
        </Form.Label>
        <br /> <br />
        <Form.Label>
          Don't have an account? <a href="/sign-up">Register now!</a>
        </Form.Label>
      </Form>
    </>
  );
};
export default SignIn;
