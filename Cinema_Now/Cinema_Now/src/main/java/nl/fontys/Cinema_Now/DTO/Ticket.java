package nl.fontys.Cinema_Now.DTO;
import nl.fontys.Cinema_Now.DTO.Enums.TicketType;

public class Ticket {
    private  static int ticketId = 1000;

    private int ticketID;
    private User holder;
    private Movie movie;
    private TicketType type;
    private int Seats[];
    private String room;
    private double price;

    public static int getTicketId() {
        return ticketId;
    }

    public static void setTicketId(int ticketId) {
        Ticket.ticketId = ticketId;
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

    public int[] getNrSeats() {
        return Seats;
    }

    public void setNrSeats(int[] nrSeats) {
        this.Seats = nrSeats;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public User getHolder()
    {
        return holder;
    }
    public void setHolder(User user)
    {
        this.holder = user;
    }

    public Movie getMovie()
    {
        return movie;
    }
    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }


    public Ticket(User user, Movie movie, TicketType type , int[] Seats, String room, double price)
    {
        this.ticketID = ticketId++;
        this.holder = user;
        this.movie = movie;
        this.type = type;
        this.Seats = Seats;
        this.room = room;
        this.price = price;
    }




    @Override
    public String toString() {
        return  "Ticket {" +
                "holder='" + holder + '\'' +
                ", movie='" + movie + '\'' +
                ", Ticket_Type='" + type.toString() + '\'' +
                ", nrOfSeats='" + Seats + '\'' +
                ", room='" + room + '\'' +
                ", price='" + price + "euro" + '\'' +
                '}';
    }


}
