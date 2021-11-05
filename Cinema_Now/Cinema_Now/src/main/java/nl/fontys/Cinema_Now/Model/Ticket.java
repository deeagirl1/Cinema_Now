package nl.fontys.Cinema_Now.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.fontys.Cinema_Now.Model.Enums.TicketType;
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

    @ManyToOne @JsonIgnore
    private User holder;

    @OneToOne @JsonIgnore
    private Movie movie;

    @Column(name = "date")
    private String date;


    public Ticket() {

    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Ticket(TicketType type,double price,String date)
    {

        this.type = type;
        this.date = date;
        this.price = price;
    }

    public Ticket(TicketType type,String date)
    {

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
