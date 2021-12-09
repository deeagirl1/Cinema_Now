import { React } from "react";
import AuthService from "../services/AuthService";
import RoomsTable from "./RoomsTable";
import NotFound from "../PageNotFound";

function RoomPage() {


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
              <h1>Rooms</h1>
            </div>
            <br/>
            <div className="container">
            <RoomsTable></RoomsTable>
            </div>
          </>
        )}

      {AuthService.getCurrentUser() === null && (
           <NotFound/>
      )}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
          <NotFound/>
        )}
    </div>
  )}

export default RoomPage;
