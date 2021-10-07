import React, { useEffect, useState } from "react";
import UserService from "../../Services/UserService";


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
           <div className="title">{user.firstName}</div>
           <br/>
           <div className="description">{user.lastName}</div>
           <br/>
           <div className="sender">{user.email}</div>
           <div className="sender">{user.address}</div>
           <div className="sender">{user.age}</div>
           </div>
       )}
        </div>
     </div>
    )
}

export default UserListComponent;