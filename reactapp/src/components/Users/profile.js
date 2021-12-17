import { useState, useEffect } from "react";
import UserService from "../services/UserService";
import AuthService from "../services/AuthService";
import {
  Box,
  Button,
  Card,
  CardContent,
  Divider,
  Grid,
  TextField,
  Typography,
} from "@mui/material";
import SignIn from "../signin_component";
import { store } from "react-notifications-component";

const Profile = (props) => {
  const [profile, setProfile] = useState("");
  const notificationSuccessful = {
    title: "Successful",
    message: "Successfully registered!",
    type: "success",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 2500,
    },
  };
  const notificationUnSuccessful = {
    title: "Something went wrong!",
    message: "Please try again!",
    type: "danger",
    insert: "top",
    container: "top-center",
    animationIn: ["animate__animated animate__fadeIn"],
    animationOut: ["animate__animated animate__fadeOut"],
    dismiss: {
      duration: 1000,
    },
  };


  useEffect(() => {
    UserService.getUserByUsername(AuthService.getCurrentUser().user).then(
      (response) => {
        setProfile(response.data);
      }
    );
  }, []);

  if (!profile) return <SignIn />;

  const handleChange = (event) => {
    setProfile({
      ...profile,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmitForm = (profile) => {
    UserService.editUser(profile);
  };

  return (
    <div className="container">
      <form autoComplete="off" noValidate {...props} onClick={handleSubmitForm(profile)}>
        <Card {...props}>
          <CardContent>
            <Box
              sx={{
                alignItems: "center",
                display: "flex",
                flexDirection: "column",
              }}
            >
              <Typography color="textPrimary" gutterBottom variant="h5" >
                {profile.firstName} {profile.lastName}
              </Typography>
              <Typography color="textSecondary" variant="body2">
                {`${profile.address}`}
              </Typography>
            </Box>
          </CardContent>
        </Card>
        <Card>
          <Divider />
          <CardContent>
            <Grid container spacing={3}>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  label="First Name"
                  name="firstName"
                  onChange={handleChange}
                  readOnly
                  value={profile.firstName}
                />
              </Grid>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  label="Last Name"
                  name="lastName"
                  onChange={handleChange}
                  readonly
                  value={profile.lastName}
                />
              </Grid>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  label="Email"
                  name="email"
                  readonly
                  onChange={handleChange}
                  value={profile.email}
                />
              </Grid>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  label="Username"
                  name="username"
                  readonly
                  onChange={handleChange}
                  value={profile.username}
                />
              </Grid>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  type="number"
                  label="Age"
                  min="0"
                  name="age"
                  readonly
                  onChange={handleChange}
                  value={profile.age}
                />
              </Grid>
              <Grid item md={6} xs={12}>
                <TextField
                  InputLabelProps={{
                    shrink: true,
                  }}
                  fullWidth
                  label="Address"
                  name="address"
                  readonly
                  onChange={handleChange}
                  value={profile.address}
                />
              </Grid>
            </Grid>
          </CardContent>
          <Divider />
          <Box
            sx={{
              display: "flex",
              justifyContent: "flex-end",
              p: 2,
            }}
          >
            <Button
              color="primary"
              variant="contained"
         
            >
              Save
            </Button>
          </Box>
        </Card>
      </form>
    </div>
  );
};

export default Profile;
