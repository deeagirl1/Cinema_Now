import { Button } from "react-bootstrap";
import Form from "react-bootstrap/Form";

// function PostComplaint(props) {
//     const [data,setData] = useState({
//        // sender: "",
//         title: "",
//         description: ""
//     })
// function handle(e){
//         const newData={...data}
//         newData[e.target.id] = e.target.value;
//         setData(newData);
//         console.log(e.data);
// }
const PostComplaint = () => {
  return (
    <div>
      <Form>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Name: </Form.Label>
          <Form.Label>
            Mark Otto
          </Form.Label>
        </Form.Group>
        <Form.Group className="mb-3" controlId="formBasicEmail">
          <Form.Label>Email address: </Form.Label>
          <Form.Label>
            mark_otto@gmail.com
          </Form.Label>
        </Form.Group>
        <Form.Group>
        <Form.Label>Title </Form.Label>
        <Form.Control type="text" placeholder="Write a title..." />
        </Form.Group>
        <br/>
        <Form.Group className="mb-3" controlId="formBasicPassword">
          <Form.Label>Your complaint:</Form.Label>
          <Form.Control as="textarea" rows="3" name="complaint" placeholder="Write your complaint..." />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default PostComplaint;
