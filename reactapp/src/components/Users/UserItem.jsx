import React from "react";
import { Card, Button} from "react-bootstrap";

function UserItem(props) {
  return (
   
      <><Card>
          {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
          <Card.Body style={{ backgroundColor: 'lightGray', borderRadius: '0%' }}>
              <Card.Text>
                  {props.user.firstName} {props.user.lastName}
                  <br /><br />
                  {props.user.email}   {props.user.isLoyal}
                  <br /><br />
              </Card.Text>
          </Card.Body>
      </Card><br /></>
  );
}
export default UserItem;
