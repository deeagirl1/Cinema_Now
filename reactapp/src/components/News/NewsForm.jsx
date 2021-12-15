import { useRef } from "react";
import React from "react";
import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";
import NewsService from "../services/NewsService";
import moment from "moment";
import { store } from "react-notifications-component";

const NewsForm = () => {
  const notificationSuccessful = {
    title: "Successful",
    message: "Post added successfully!",
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

  const title = useRef();
  const description = useRef();

  const handleSubmit = (e) => {
    e.preventDefault();
    const titleRef = title.current.value;
    const descriptionRef = description.current.value;

    const newsPost = {
      title: titleRef,
      description: descriptionRef,
      postedAt: moment().format("DD/MM/YYYY"),
    };
    console.log(newsPost);

    NewsService.createNewPost(newsPost)
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

  let menu = "";

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          {menu}
        </Form.Group>
        <Form.Group>
          <Form.Label>News title </Form.Label>
          <Form.Control
            type="text"
            ref={title}
            placeholder="Write a title..."
            required
          />
        </Form.Group>
        <br />
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>News description:</Form.Label>
          <Form.Control
            as="textarea"
            ref={description}
            rows="3"
            name="complaint"
            placeholder="Write your complaint..."
            required
          />
        </Form.Group>
        <Button variant="primary" type="submit" style={{ alignSelf: "center" }}>
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default NewsForm;
