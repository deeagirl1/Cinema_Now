package nl.fontys.Cinema_Now.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="projection")
public class Projection {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;


    public Projection() {

    }

    public Projection(String id, String time, String date) {
        this.id = id;
        this.date = date;
        this.time = time;
    }

    public Projection(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
