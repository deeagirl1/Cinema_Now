import React, { Component } from "react";
import { withRouter } from "react-router-dom";
import AuthService from "../components/services/AuthService";
import SignIn from '../components/signin_component';

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
      const user = JSON.parse(localStorage.getItem("user"));

      if (user) {
        const decodedJwt = parseJwt(user.access_token);

        if (decodedJwt.exp * 1000 < Date.now()) {
          AuthService.logOut();
        }
      }
    });
  }

  render() {
    return <h1>You need to sign in again.</h1>;
  }
}

export default withRouter(AuthVerify);
