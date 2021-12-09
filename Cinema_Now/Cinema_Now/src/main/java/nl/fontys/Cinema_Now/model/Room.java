package nl.fontys.Cinema_Now.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name ="rooms")
public class Room {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    public Room() {

    }

    public String getId() {
        return id;
    }

    public void setId(String room_id) {
        this.id = room_id;
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

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;

    }
    public Room(String id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;

    }

}