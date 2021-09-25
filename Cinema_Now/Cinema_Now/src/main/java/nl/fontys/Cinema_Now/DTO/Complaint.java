package nl.fontys.Cinema_Now.DTO;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

public class Complaint {

    private static int id = 1000;
    private int ID;
    private String title;
    private String container;
    private String name;
    private String email;
    private User sender;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }




    public Complaint(User user, String title, String container)
    {
        this.ID = id++;
        this.title = title;
        this.container = container;
        this.sender = user;
        this.name = user.getFirstName() + " " + user.getLastName();
        this.email = user.getEmail();

    }

    @Override
    public String toString() {
        return  "Complaint {" +
                "title='" + title + '\'' +
                ",description='" + container + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
