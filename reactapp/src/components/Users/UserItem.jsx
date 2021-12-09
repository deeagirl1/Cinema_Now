import React from "react";
import { Card} from "react-bootstrap";

function UserItem(props) {
  return (
   
      <><Card>
          {/* <Card.Img variant="center" src="holder.js/100px180" /> */}
          <Card.Body style={{ backgroundColor: 'lightGray', borderRadius: '0%' }}>
              <Card.Text>
                  {props.user.firstName} {props.user.lastName}
                  <br /><br />
                  {props.user.email}   {JSON.stringify(props.user.loyal)}
                  <br /><br />
              </Card.Text>
          </Card.Body>
      </Card><br /></>
  );
}
export default UserItem;
