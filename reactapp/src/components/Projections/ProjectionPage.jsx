import { React } from "react";
import AuthService from "../services/AuthService";
import ProjectionTable from "./ProjectionTable";
import NotFound from "../PageNotFound";

function ProjectionPage() {
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
              <h1>Projections</h1>
            </div>
            <br/>
            <div className="container">
            <ProjectionTable></ProjectionTable>
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

export default ProjectionPage;
