import qrcode from 'qrcode'
import { QRCode } from 'react-qr-svg';
import TicketService from '../../Services/TicketService';

function QRCodeGenerator(){
    return (
        <div>
              <QRCode
            level="Q"
            style={{ width: 256 }}
            value={JSON.stringify(TicketService)}
          />
        </div>
    )
}

export default QRCodeGenerator;