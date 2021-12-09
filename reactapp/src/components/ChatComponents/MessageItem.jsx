import React from 'react';
import {
    Card,
    CardHeader,
    Grid
  } from '@mui/material';

function MessageItem(props){

    let activeUser = JSON.parse(localStorage.getItem('user'));


    if(activeUser.user === props.msg.sender){
        return (    
            <Grid item xs={12}  align="right">
                 <Card  style={{width: "250px"}}>
                    <CardHeader
                    subheader={props.msg.sender}
                    title={props.msg.content}
                    style={{height:"60px"}}
                    
                    />
                </Card>
               {/* <ListItemText align="right" primary={props.msg.content}></ListItemText>
               <ListItemText align="right" secondary={props.msg.sender}></ListItemText> */}
            </Grid>
        )
    }
    else{
        return (    
            <Grid item xs={12} align="left">
            <Card  style={{width: "250px"}}>
               <CardHeader
               subheader={props.msg.sender}
               title={props.msg.content}
               style={{height:"60px"}}
               
               />
           </Card>
          {/* <ListItemText align="right" primary={props.msg.content}></ListItemText>
          <ListItemText align="right" secondary={props.msg.sender}></ListItemText> */}
       </Grid>
        )
    }
    
}
export default MessageItem;