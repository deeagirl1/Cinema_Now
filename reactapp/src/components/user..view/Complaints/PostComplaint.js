import { React,useEffect, useState, Fragment, useRef } from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import AuthService from "../../services/AuthService";
import ComplaintService from "../../services/ComplaintService";

  var isLoggedIn = false;

  if(AuthService.getCurrentUser() !== null){
      isLoggedIn = true;
  }

  const PostComplaint = () => { 

    const [user,setUser] = useState(null);
    useEffect(() => {                                               
      const username = JSON.parse(localStorage.getItem("user"));
      
      if(username && username.user){
      setUser(username.user);
      }
    }, []);

    const title = useRef();
    const container = useRef();
    // const sentDate = useRef();

    const handleSubmit = (e) => {
      e.preventDefault();
    const titleRef = title.current.value;
    const containerRef = container.current.value;
    
    const complaint = 
    {
      title : titleRef,
      container : containerRef,
      sentDate : '26/04/2021'
    }
    console.log(complaint);
    ComplaintService.createComplaint(complaint) ;
    }
  
    let menu = '';

  // if(isLoggedIn === false){
  //     menu = (
  //       <Fragment>
  //       <Form.Group>
  //       <Form.Label>Email </Form.Label>
  //       <Form.Control type="email" placeholder="Write your email..." />
  //       </Form.Group>
  //       </Fragment>
  //     )
  // } 
  if(isLoggedIn === true) {
      menu = (
        <Fragment>
        <Form.Label>Username: </Form.Label> <br/>
          <Form.Label>
            {user}
        </Form.Label>
        </Fragment>
      )
  }
  if(!user){
    return <h1>Error 404, page not found</h1>
  }
  else
  {
  return (
     
    <div>
      <Form onSubmit = {handleSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          {menu}
        </Form.Group>
        <Form.Group>
        <Form.Label>Title </Form.Label>
        <Form.Control type="text" ref={title} placeholder="Write a title..."/>
        </Form.Group>
        <br/>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Your complaint:</Form.Label>
          <Form.Control as="textarea" ref={container}  rows="3" name="complaint" placeholder="Write your complaint..."/>
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};
  }

export default PostComplaint;
