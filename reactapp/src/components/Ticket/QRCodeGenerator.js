import qrcode from 'qrcode'
import { QRCode } from 'react-qr-svg';
import TicketService from '../../Services/TicketService';

function QRCodeGenerator(){
    return (
        <div>
            <QRCode>
 
            </QRCode>
        </div>
    )
}

export default QRCodeGenerator;