package nl.fontys.Cinema_Now.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name="tickets")
public  class Ticket {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "type")
    private TicketType type;

    @Column(name = "price")
    private double price;

    @Column(name = "amountOfPeople")
    private int amountOfPeople;

    @ManyToOne @JsonIgnore
    private AppUser holder;

    @OneToOne @JsonIgnore
    private Movie movie;

    @OneToOne @JsonIgnore
    private Room room;

    @OneToOne
    private Projection projection;

    public Ticket() {

    }

    public AppUser getHolder() {
        return holder;
    }

    public void setHolder(AppUser holder) {
        this.holder = holder;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }

    public Projection getProjection() {
        return projection;
    }

    public void setProjection(Projection projection) {
        this.projection = projection;
    }

    public Ticket(TicketType type, double price, Projection projection)
    {

        this.type = type;
        this.projection = projection;
        this.price = price;
    }

    public Ticket(TicketType type,Projection projection)
    {

        this.type = type;
        this.projection = projection;
    }

    public Ticket(String id, TicketType type, double price, int amountOfPeople, AppUser holder, Movie movie, Room room, Projection projection) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.amountOfPeople = amountOfPeople;
        this.holder = holder;
        this.movie = movie;
        this.room = room;
        this.projection = projection;
    }

    @Override
    public String toString() {
        return  "Ticket {" +
                ", Ticket_Type='" + type.toString() + '\'' +
                ", price='" + price + "euro" + '\'' +
                ", date='" + projection.getDate() + '\'' +
                '}';
    }

}
