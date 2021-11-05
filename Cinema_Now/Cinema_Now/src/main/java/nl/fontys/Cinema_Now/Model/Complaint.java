package nl.fontys.Cinema_Now.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name = "complaint")
public class Complaint {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "container")
    private String container;

    @Column(name = "sendDate")
    private String sentDate;


    @ManyToOne @JsonIgnore
    private User sender;

    public Complaint() {

    }

    public User getSender() {return sender;}

    public void setSender(User sender) {this.sender = sender;}

    public String getID() {
        return id;
    }

    public void setID(String ID) {
        this.id = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public Complaint(String title, String container, String sentDate)
    {
        this.title = title;
        this.container = container;
        this.sentDate = sentDate;

    }

    @Override
    public String toString() {
        return  "Complaint {" +
                "title='" + title + '\'' +
                ",description='" + container + '\'' +
                ",sentDate='" + sentDate + '\'' +

                '}';
    }
}
