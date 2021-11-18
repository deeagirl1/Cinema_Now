package nl.fontys.Cinema_Now.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="rooms")
public class Room {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String room_id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;


    @OneToOne @JsonIgnore
    private Movie movie;

    @JsonIgnore
    @OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();

    public Room() {

    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Room(String name, int capacity, Movie movie) {
        this.name = name;
        this.capacity = capacity;
        this.movie = movie;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}