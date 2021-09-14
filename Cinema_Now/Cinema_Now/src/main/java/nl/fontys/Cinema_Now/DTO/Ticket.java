package nl.fontys.Cinema_Now.DTO;
import lombok.Getter;

public class Ticket {
    private  static int ticketId = 1000;
    @Getter private int ticketID;
    @Getter private String holder;
    @Getter private String movie;
    @Getter private int nrSeats;
    @Getter private int room;
    @Getter private double price;

    public Ticket(User user, Movie movie, int nrSeats, int room, double price)
    {
        this.ticketID = ticketId++;
        this.holder = user.getFirstName() + user.getLastName();
        this.movie = movie.getName();
        this.nrSeats = nrSeats;
        this.room = room;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Ticket {" +
                "holder='" + holder + '\'' +
                ", movie='" + movie + '\'' +
                ", nrOfSeats='" + nrSeats + '\'' +
                ", room='" + room + '\'' +
                ", price='" + price + "euro" + '\'' +
                '}';
    }

}
