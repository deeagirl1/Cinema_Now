import { React, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";

import MoviesService from "../../services/MoviesService";

  const PostMovie = () => { 

    const movieName = useRef();
    const container = useRef();

    const handleSubmit = (e) => {
      e.preventDefault();
;
    const movie = 
    {
      title : "test",
      container : "test",
      sentDate : '26/04/2021'
    }
    console.log(movie);
    MoviesService.createComplaint(movie) ;
    }
  
  return (
     
    <div>
      <Form onSubmit = {handleSubmit}>
        <Form.Group>
        <Form.Label>Title </Form.Label>
        <Form.Control type="text"  placeholder="Write a title..."/>
        </Form.Group>
        <br/>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Your complaint:</Form.Label>
          <Form.Control as="textarea" rows="3" name="complaint" placeholder="Write your complaint..."/>
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostMovie;
