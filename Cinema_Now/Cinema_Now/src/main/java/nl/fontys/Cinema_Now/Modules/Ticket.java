package nl.fontys.Cinema_Now.Modules;
import nl.fontys.Cinema_Now.Modules.Enums.TicketType;

public abstract class Ticket {
    private  static int ticketId = 1000;

    private int ticketID;
    private TicketType type;
    private double price;
    private String holder;
    private String movie;
    private String date;

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getTicketID() {
        return ticketID;
    }
    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }
    public TicketType getType() {
        return type;
    }
    public void setType(TicketType type) {
        this.type = type;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ticket(TicketType type,double price,String date)
    {
        this.ticketID = ticketId++;
        this.type = type;
        this.date = date;
        this.price = price;
    }

    public Ticket(TicketType type,String date)
    {
        this.ticketID = ticketId++;
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return  "Ticket {" +
                ", Ticket_Type='" + type.toString() + '\'' +
                ", price='" + price + "euro" + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

}
