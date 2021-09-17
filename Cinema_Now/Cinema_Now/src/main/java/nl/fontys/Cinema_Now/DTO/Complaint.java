package nl.fontys.Cinema_Now.DTO;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

public class Complaint {

    private static int id = 1000;
    @Getter public int ID;
    @Getter public String Title;
    @Getter public String Container;
    @Getter public String Email;
    @Getter public String Sender;

    public Complaint(User user, String title, String container)
    {
        this.ID = id++;
        this.Sender = user.getLastName() ;
        this.Title = title;
        this.Container = container;;
        this.Email = user.getEmail();

    }

    @Override
    public String toString() {
        return  "Complaint {" +
                 "email='" + Email + '\'' +

                ",title='" + Title + '\'' +

                ",description='" + Container + '\'' +

                '}';
    }
}
