import React, { Component } from "react";
import { withRouter } from "react-router-dom";
import AuthService from "../components/services/AuthService";

const parseJwt = (token) => {
  try {
    return JSON.parse((token.split('.')[1]));
  } catch (e) {
    return null;
  }
};

class AuthVerify extends Component {
  constructor(props) {
    super(props);

    props.history.listen(() => {
      const token = JSON.parse(localStorage.getItem("access_token"));

      if (token) {
        const decodedJwt = parseJwt(token.accessToken);

        if (decodedJwt.exp * 1000 < Date.now()) {
          AuthService.logOut();
        }
      }
    });
  }

  render() {
    return <div>Please sign in again.</div>;
  }
}

export default withRouter(AuthVerify);
