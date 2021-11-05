import React from 'react'
import { Grid, Avatar, TextField, Button, Typography,Link } from '@material-ui/core'
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import FormControlLabel from '@material-ui/core/FormControlLabel';
import Checkbox from '@material-ui/core/Checkbox';
const FormSignUp=()=>{

    const avatarStyle={backgroundColor:'#1bbd7e'}
    const btnstyle={margin:'10px 0', padding:'15px'}
    return(
        <Grid> 
            
                <Grid align='center' >
                     <Avatar style={avatarStyle} font-size='10px'><LockOutlinedIcon/></Avatar>
                    <h2>Sign In</h2>
                </Grid>
                <TextField label='First name: ' placeholder='Enter your email' fullWidth required/>
                &nbsp;
                <TextField label='Last name:' placeholder='Enter password' fullWidth required/>
                &nbsp;
                <TextField label='First name: ' placeholder='Enter your email' fullWidth required/>
                &nbsp;
                <TextField label='Last name:' placeholder='Enter password'  fullWidth required/>
                &nbsp;
                <TextField label='First name: ' placeholder='Enter your email' fullWidth required/>
                &nbsp;
                <TextField label='Last name:' placeholder='Enter password'  fullWidth required/>
             
                <FormControlLabel
                    control={
                    <Checkbox
                        name="checkedB"
                        color="primary"
                    />
                    }
                    label="I accept terms"
                 />
                 
                <Button type='submit' color='primary' variant="contained" style={btnstyle} fullWidth>Sign in</Button>
               
                <Typography > Do you have an account ? 
                     <Link href="/sign-in" >
                        Sign In 
                </Link>
                </Typography>
               
            
        </Grid>
    )
}
export default FormSignUp;