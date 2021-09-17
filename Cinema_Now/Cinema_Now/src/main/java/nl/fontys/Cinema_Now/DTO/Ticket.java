package nl.fontys.Cinema_Now.DTO;
import lombok.Getter;
import lombok.Setter;

public class Ticket {
    private  static int ticketId = 1000;
    @Getter public int ticketID;
    @Getter @Setter public User holder;
    @Getter @Setter public String movie;
    @Getter @Setter public int nrSeats;
    @Getter @Setter public int room;
    @Getter @Setter public double price;

    public Ticket(User user, Movie movie, int nrSeats, int room, double price)
    {
        this.ticketID = ticketId++;
        this.holder = user;
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
