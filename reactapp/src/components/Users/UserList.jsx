import React from "react";
import UserItem from "./UserItem";
function UserList(props){

    const handleDelete = (id) =>{
        props.onDelete(id);
    };

return(
    <ul>
        {props.users.map((user)=>(
            <UserItem key = {user.username} user = {user} onDelete = {handleDelete}></UserItem>
        ))}
    </ul>
    )

}

export default UserList;