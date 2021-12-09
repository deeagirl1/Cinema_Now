import React, { useState, useEffect, useRef } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';
import Divider from '@material-ui/core/Divider';
import TextField from '@material-ui/core/TextField';
import Typography from '@material-ui/core/Typography';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import Fab from '@material-ui/core/Fab';
import SendIcon from '@material-ui/icons/Send';
import SockJS from 'sockjs-client';
import Stomp from 'stompjs';
import MessageItem from './MessageItem';
import SignIn from '../signin_component';

const ENDPOINT = "http://localhost:8080/chat";

const useStyles = makeStyles({
  table: {
    minWidth: 650,
  },
  chatSection: {
    width: '75%',
    height: '80vh',
    justifyContent: "center"
  },
  headBG: {
      backgroundColor: '#e0e0e0'
  },
  borderRight500: {
      borderRight: '1px solid #e0e0e0'
  },
  messageArea: {
    height: '70vh',
    overflowY: 'auto'
  }
});


const Chat = () => {
  const classes = useStyles();

  const [stompClient, setStompClient] = useState(null);
//   const [msgToSend, setSendMessage] = useState("Enter your message here!");
  const inputRef = useRef();
  const [messages, setMessages] = useState([]);
  let activeUser = JSON.parse(localStorage.getItem('user'));

  useEffect(() => {
    // use SockJS as the websocket client
    const socket = SockJS(ENDPOINT);
    // Set stomp to use websockets
    const stompClient = Stomp.over(socket);
    // connect to the backend
    stompClient.connect({}, () => {
      // subscribe to the backend
      stompClient.subscribe('/topic/public', (data) => {
        console.log(data);
        onMessageReceived(data);
      });
    });
    // maintain the client for sending and receiving
    setStompClient(stompClient);
  }, []);

  if(activeUser === null) return <SignIn/>
  // send the data using Stomp
  function sendMessage() {
    const enteredMsg = inputRef.current.value;
    if(enteredMsg !== ""){
        stompClient.send("/app/chat.send", {}, JSON.stringify({'content': enteredMsg, "sender" : activeUser.user }));  
        inputRef.current.value= ''
    }
  };

  window.onbeforeunload = function() {
    // websocket.onclose = function () {}; // disable onclose handler first
    stompClient.close();
    console.log("disconnected")
};


 
  // display the received data
  function onMessageReceived(data)
  {
    const result=  JSON.parse(data.body);
    setMessages(prevItems => [...prevItems, {result}]);  
  };

  return (
      <div>
        <Grid container style={{marginLeft:"100px"}}>
            <Grid item xs={10} >
                <Typography variant="h5" className="header-message">Chat</Typography>
            </Grid>
        </Grid>
        <Grid container component={Paper} className={classes.chatSection} style={{marginLeft:"100px"}}>
            <Grid item xs={9}>
                <List className={classes.messageArea} >
                {messages.map((msg) => (
                    <ListItem key={msg.result.content} >
                        <Grid container >
                            <MessageItem msg={msg.result}  />
                        </Grid>     
                    </ListItem> 
                ))}
                </List>
                
                <Divider />
                <Grid container >
                    <Grid item xs={11} >
                        <TextField id="outlined-basic-email"
                         label="Type Something"
                        //  onChange={(event) => setSendMessage(event.target.value)}
                        inputRef={inputRef}
                         fullWidth />
                    </Grid>
                    <Grid xs={1} >
                        <Fab color="primary" aria-label="add" onClick={sendMessage} ><SendIcon /></Fab>
                    </Grid>
                </Grid>
            </Grid>
        </Grid>
      </div>
  );
}

export default Chat;