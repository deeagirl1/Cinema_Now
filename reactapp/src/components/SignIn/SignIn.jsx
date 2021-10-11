import React from 'react';
import {Button, Col, Container, Form, Row} from "react-bootstrap";

const SignIn = () => {
    return (
        <>
            <Container>
                <Row className="mt-5">
                    <Col lg={10} md={6} sm={15} className="p-5 m-auto shadow-sm rounded-lg">
                        <Form>
                            <Form.Group controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control type="email" placeholder="Enter email" />
                            </Form.Group>
                            <br/>
                            <Form.Group controlId="formBasicPassword">
                                <Form.Label>Password</Form.Label>
                                <Form.Control type="password" placeholder="Password" />
                            </Form.Group>
                            <br/>
                            <Button variant="primary" size="lg" type="submit">
                                Login
                            </Button>
                        </Form>
                    </Col>
                </Row>
            </Container>
        </>
    );
};

export default SignIn;