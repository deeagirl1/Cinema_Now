import { useEffect, useState } from 'react';
import TicketService from '../services/TicketService';


function QRCodeGenerator(){

  let param = window.location.pathname;
  let id = param.split("/").pop();


  const [ticket,setTicket] = useState(null);
  const [word, setWord] = useState("");
  const [size] = useState(250);
  const [qrCode, setQrCode] = useState("");
  

  useEffect(() => {
    TicketService.getTicketById(id).then((response) => {
    console.log(response.data);
    setTicket(response.data);
  });
}, []);


  useEffect(() => {
    setQrCode
 (`http://api.qrserver.com/v1/create-qr-code/?data=${word}!&size=${size}x${size}`);
  }, [word,size]);
  
  function handleClick() {
    setWord(JSON.stringify(ticket));
  }
  
  return (
    <div className="App">
      <h1>QR Code Generator</h1>
      <div className="input-box">
        <div className="gen">
          <button className="button" onClick = {handleClick()}
            >
            Generate
          </button>
        </div>
      </div>
      <div className="output-box">
        <img src={qrCode} alt="" />
        <a href={qrCode} download="QRCode">
          <button type="button">Download</button>
        </a>
      </div>
    </div>
  );
}
export default QRCodeGenerator;