import React from "react";
import {
  Grid,
  Avatar,
  TextField,
  Button,
  Typography,
  Link,
} from "@material-ui/core";
import LockOutlinedIcon from "@material-ui/icons/LockOutlined";
import FormControlLabel from "@material-ui/core/FormControlLabel";
import Checkbox from "@material-ui/core/Checkbox";
const Login = () => {
  const avatarStyle = { backgroundColor: "#1bbd7e" };
  const btnstyle = { margin: "10px 0", padding: "15px" };
  return (
    <Grid>
      <Grid align="center">
        <Avatar style={avatarStyle} font-size="10px">
          <LockOutlinedIcon />
        </Avatar>
        <h2>Sign In</h2>
      </Grid>
      <TextField
        label="Email"
        placeholder="Enter your email"
        fullWidth
        required
      />
      &nbsp;
      <TextField
        label="Password"
        placeholder="Enter password"
        type="password"
        fullWidth
        required
      />
      &nbsp;
      <FormControlLabel
        control={<Checkbox name="checkedB" color="primary" />}
        label="Remember me"
      />
      <Button
        type="submit"
        color="primary"
        variant="contained"
        style={btnstyle}
        fullWidth
      >
        Sign in
      </Button>
      <Typography>
        <Link href="/reset-password">Forgot password ?</Link>
      </Typography>
      <Typography>
        {" "}
        Don't have an account ?<Link href="/sign-up">Sign Up</Link>
      </Typography>
    </Grid>
  );
};

export default Login;
