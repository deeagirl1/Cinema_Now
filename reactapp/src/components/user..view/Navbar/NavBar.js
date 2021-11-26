import React from "react";
import { Navbar, Nav, Button, Container } from "react-bootstrap";
import { Fragment } from "react";
import AuthService from "../../services/AuthService";

const NavBar = () => {
  return (
    <div className="cinema_now">
      <Navbar bg="dark" expand="lg" variant="dark">
        <Container fluid>
          <Navbar.Brand href="/news">Cinema_Now</Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0"
              style={{ maxHeight: "200px" }}
              navbarScroll
            >
              <Nav.Link href="/news">News</Nav.Link>
              <Nav.Link href="/schedule" id="schedule">
                Schedule
              </Nav.Link>

              {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
                  <Fragment>
                  <Nav>
                    <Nav.Link href="/received-complaints">
                      Received Complaints
                    </Nav.Link>
                  </Nav>
                    <Nav>
                    <Nav.Link href="/users">
                     Users
                    </Nav.Link>
                  </Nav>
                  </Fragment>
                )}
              {AuthService.getCurrentUser() !== null &&
                AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
                  <Nav>
                    <Nav.Link href="/complaints">Complaints</Nav.Link>
                  </Nav>
                )}
            </Nav>
            {AuthService.getCurrentUser() === null && (
              <Fragment>
                <Nav>
                  <Button href="/sign-in">Sign In</Button>
                </Nav>
                &nbsp;&nbsp;
                <Nav>
                  <Button href="/sign-up">Sign Up</Button>
                </Nav>
              </Fragment>
            )}
            {AuthService.getCurrentUser() !== null && (
              <Fragment>
                <Nav>
                  <Button href="/sign-out">Sign out</Button>
                </Nav>
                &nbsp;&nbsp;
                <Nav>
                  <Button href="/profile">Your account</Button>
                </Nav>
              </Fragment>
            )}
            &nbsp;&nbsp;
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default NavBar;

{
  /* <Form className="d-flex">
<FormControl
  type="search"
  placeholder="Search..."
  className="me-2"
  aria-label="Search"
/>
<Button>Search</Button>
</Form>
&nbsp;&nbsp; */
}
