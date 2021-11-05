import React from "react";
import {
  Navbar,
  Nav,
  Form,
  FormControl,
  Button,
  Container,
} from "react-bootstrap";

const NavBar = () => {
  return (
    <div className="cinema_now">
      <Navbar bg="dark" expand="lg" variant="dark">
        <Container fluid>
          <Navbar.Brand href="/news" > <img src="logo.png" alt="logo" title="Cinema_Now"></img></Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "200px"}}
              navbarScroll
              
            >
              <Nav.Link href="/news">News</Nav.Link>
              <Nav.Link href="/schedule">Schedule</Nav.Link>
              <Nav.Link href="/complaints">Complaints  </Nav.Link>
            </Nav>

            <Nav>
            <Button href="/sign-in">Sign In</Button>
            &nbsp;&nbsp;
            <br/>
        
            <Button href="/sign-up">Sign Up</Button >
            &nbsp;&nbsp;
            <br/>
   
            </Nav>
            
            <Form className="d-flex">
              <FormControl
                type="search"
                placeholder="Search..."
                className="me-2"
                aria-label="Search"
              />
              <Button>Search</Button>  
            </Form>
            <br/>
            <Nav>
            <Navbar.Text id = "userLoggedIn">
            &nbsp;
            Good to see you back, <a href="/sign-in">Mark Otto!</a>
            </Navbar.Text>
            </Nav>
            
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavBar;
