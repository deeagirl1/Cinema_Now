import { useLocation } from "react-router-dom";
import { QRCode } from "react-qr-svg";

function QRCodeGenerator() {
  const location = useLocation();
  const ticket = location.state;

  const finalTicket = {
    movie: ticket.movieId,
    holder: ticket.holderId,
    projection: ticket.projectionId,
  };

  console.log(finalTicket);

  return (
    <div className="container">
      <QRCode
        level="Q"
        style={{ width: 256 }}
        value={JSON.stringify(finalTicket)}
      />
    </div>
  );
}
export default QRCodeGenerator;
