import { React, useState, useEffect } from "react";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import UserList from "./UserList";

function UserPage() {
  const [users, setUsers] = useState(null);
  
  useEffect(() => {
    UserService.getUsers().then((response) => {
      console.log(response.data);
      setUsers(response.data);
    });
  
   }, []);

  function deleteUser(id) {
    const newUser = [...users];
    const index = newUser.indexOf(id);
    newUser.splice(index, 1);
    UserService.deleteUser(id);
    setUsers(newUser);
  }

  if (!users) 
    return null;
  
  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
            <><h1>Users</h1><UserList users={users} onDelete={deleteUser}></UserList></>
        )}
    </div>
  );
}

export default UserPage;
