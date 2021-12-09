import { useState, useEffect } from 'react';
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
  Avatar,
  CardActions,
  Typography
} from '@mui/material';

  
 export const Profile = (props) => {
  const [profile,setProfile] = useState("");
   
    useEffect(() => {
      
        UserService.getUserByUsername(AuthService.getCurrentUser().user).then((response) => {
            setProfile(response.data);
        });
    }, [])    

  const handleChange = (event) => {
    setProfile({
      ...profile,
      [event.target.name]: event.target.value
    });
  };
  
  const handleSubmitButton = (profile) => {
    UserService.editUser(profile);
    console.log(profile);
}

  return (
    <div className ="container">
    <form
      autoComplete="off"
      noValidate
      {...props}
    >
        <Card {...props}>
      <CardContent>
        <Box
          sx={{
            alignItems: 'center',
            display: 'flex',
            flexDirection: 'column'
          }}
        >
          <Avatar
            src={profile.avatar}
            sx={{
              height: 64,
              mb: 2,
              width: 64
            }}
          />
          <Typography
            color="textPrimary"
            gutterBottom
            variant="h5"
          >
            {profile.firstName} {profile.lastName}
          </Typography>
          <Typography
            color="textSecondary"
            variant="body2"
          >
            {`${profile.address}`}
          </Typography>
        </Box>
      </CardContent>
      <Divider />
      <CardActions>
        <Button
          color="primary"
          fullWidth
          variant="text"
        >
          Upload picture
        </Button>
      </CardActions>
    </Card>
      <Card>
        <Divider />
        <CardContent>
          <Grid
            container
            spacing={3}
          >
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                }}
                fullWidth
                label="First Name"
                name="firstName"
                onChange = {handleChange}
                readOnly
                value={profile.firstName}
          
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                }}
                fullWidth
                label="Last Name"
                name="lastName"
                onChange = {handleChange}
                readonly
                value={profile.lastName}
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                }}
                fullWidth
                label="Email"
                name="email"
                readonly
                onChange = {handleChange}
                value={profile.email}
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
              <TextField
                InputLabelProps={{
                shrink: true,
                }}
                fullWidth
                label="Username"
                name="username"
                readonly
                onChange = {handleChange}
                value={profile.username}
              />
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
            <Grid
              item
              md={6}
              xs={12}
            >
            </Grid>
          </Grid>
        </CardContent>
        <Divider />
        <Box
          sx={{
            display: 'flex',
            justifyContent: 'flex-end',
            p: 2
          }}
        >
          <Button
            color="primary"
            variant="contained"
            onClick = {handleSubmitButton(profile)}
          >
            Save
          </Button>
        </Box>
      </Card>
    </form>
    </div>
  );
};

