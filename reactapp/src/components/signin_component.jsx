import React from "react";
import { Button, Form } from "react-bootstrap";
import { useHistory } from "react-router";
import AuthService from "./services/AuthService";

const SignIn = () => {
  const [msg, setMsg] = React.useState(null);
  const History = useHistory();
  const username = React.useRef();
  const password = React.useRef();
  const handleLogin = (e) => {
    
    e.preventDefault();
    if (username.current.value || password.current.value) {
      AuthService.login(username.current.value, password.current.value)
        .then((response) => response.json())
        .then((responseData) => {
          console.log(JSON.stringify(responseData));
          localStorage.setItem("user", JSON.stringify(responseData));
          History.push("/");
          window.location.reload();
        
        })
        .catch((_err) => {
          setMsg(_err);
        });
    } else {
      <div className="alert alert-danger" role="alert">
        Provide username and password.
      </div>;
    }
  };

  return (
    <Form onSubmit={handleLogin}>
      <Form.Group className="mb-3" controlId="formBasicUsername">
      <Form.Label>Username</Form.Label>
        <Form.Control
          type="text"
          className="form-control"
          placeholder="Enter your username"
          ref={username}
        />
      </Form.Group >

      <Form.Group className="mb-3" controlId="formBasicPassword">
      <Form.Label>Password</Form.Label>
        <Form.Control 
        type="password" 
        placeholder="Enter your password" 
        ref={password}
        />
         <br/>
      </Form.Group>
      <Button type="submit" className="btn btn-primary btn-block">
        Submit
      </Button>
      <br/> <br/>
      <Form.Label className="forgot-password text-right">
        Forgot <a href="/reset-password">password?</a>
      </Form.Label>
      <br/> <br/>
      <Form.Label>
        Don't have an account? <a href="/sign-up">Register now!</a>
      </Form.Label>
      <Form.Label>{msg}</Form.Label>
    </Form>
  );
};
export default SignIn;
