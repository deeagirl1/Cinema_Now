package nl.fontys.Cinema_Now.DTO;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

public class Complaint {

    private static int id = 1000;
    @Getter private int ID;
    @Getter private String Title;
    @Getter private String Container;
    @Getter private String Name;
    @Getter private String Email;
    @Getter private User Sender;

    public Complaint(User user, String title, String container)
    {
        this.ID = id++;
        this.Title = title;
        this.Container = container;
        this.Sender = user;
        this.Name = user.getFirstName() + user.getLastName();
        this.Email = user.getEmail();

    }

    @Override
    public String toString() {
        return  "Complaint {" +
                "title='" + Title + '\'' +
                ",description='" + Container + '\'' +
                ", name='" + Name + '\'' +
                ", email='" + Email + '\'' +
                '}';
    }
}
