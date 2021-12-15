import { React } from "react";
import AuthService from "../services/AuthService";
import ComplaintTable from "./ComplaintTable";
import PostComplaint from "./PostComplaint";
import SignIn from "../signin_component";
import { Label } from "reactstrap";

function ComplaintPage() {

  return (
    <div>
      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_ADMIN]") && (
          // <><MovieForm /><br/></
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
              <h1>Received complaints</h1>
            </div>
            <div className="container">
              <ComplaintTable />
            </div>
          </>
        )}
      {AuthService.getCurrentUser() === null && <SignIn />}

      {AuthService.getCurrentUser() !== null &&
        AuthService.getCurrentUser().roles.includes("[ROLE_USER]") && (
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
              <h1>Send a complaint!</h1>
              <br />
            </div>
           
            <div className="container">
            <Label>
                We are sorry for any inconvience you might have encountered
                during your visit.
              </Label>
              <br/>
              <PostComplaint />
            </div>
          </>
        )}
    </div>
  );
}

export default ComplaintPage;
