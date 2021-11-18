import { useEffect, useState } from 'react';


function QRCodeGenerator(){
  const [temp, setTemp] = useState("");
  const [word, setWord] = useState("");
  const [size] = useState(250);
  const [qrCode, setQrCode] = useState("");

  const ticket = {
    title: "test",
    container : "test",
    date : "test"
  }
  
  
  // Changing the URL only when the user
  // changes the input
  useEffect(() => {
    setQrCode
 (`http://api.qrserver.com/v1/create-qr-code/?data=${word}!&size=${size}x${size}`);
  }, [word,size]);
  
  function handleClick() {
    setWord(ticket);
  }
  
  return (
    <div className="App">
      <h1>QR Code Generator</h1>
      <div className="input-box">
        <div className="gen">
          <button className="button" 
            onClick={handleClick}>
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