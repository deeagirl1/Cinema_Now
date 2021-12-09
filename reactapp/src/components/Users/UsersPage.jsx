import { React, useState, useEffect } from "react";
import NotFound from "../PageNotFound";
import AuthService from "../services/AuthService";
import UserService from "../services/UserService";
import UserTable from "./UserTable";

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

  if (
    (AuthService.getCurrentUser() !== null &&
      AuthService.getCurrentUser().roles.includes("[ROLE_USER]")) ||
    AuthService.getCurrentUser() === null
  ) {
    return <NotFound />;
  }

  if (!users) return <h1>No users found.</h1>;

  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          <>
            <div
              style={{
                display: "flex",
                marginTop: "10px",
                justifyContent: "center",
                alignItems: "top",
                height: "10vh",
              }}
            >
              <h1>Users</h1>
              </div>
            <UserTable users={users} onDelete={deleteUser}></UserTable>
        
          </>
        )}
    </div>
  );
}

export default UserPage;
