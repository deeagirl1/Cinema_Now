import React, { useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import UserService from "../services/UserService";


function UserListComponent(){
    const [users,setUsers] = useState([]);

    useEffect(() => {
        getUsers()
    }, [])

    const getUsers = () => {
        UserService.getUsers().then((response) => {
            setUsers(response.data);
            console.log(response.data);
        });
    }

    return(
        <div>
        <div  class = "complaint-item-container">
       {users.map(
           user => 
         <div key={user.id}>
           <div className="firstName">{user.firstName}</div>
           <div className="lastName">{user.lastName}</div>
       
           <div className="email">{user.email}</div>
           </div>
       )}
           <br/>
        </div>
     </div>
    )
}

export default UserListComponent;