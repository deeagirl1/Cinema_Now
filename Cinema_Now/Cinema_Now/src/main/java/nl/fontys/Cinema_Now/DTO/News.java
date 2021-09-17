package nl.fontys.Cinema_Now.DTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class News {
    private static int id = 1;
    @Getter private int ID;
    @Getter @Setter private String Title;
    @Getter @Setter private String Description;
    @Getter @Setter private String Date;


    public News(String title, String description, String date)
    {
        this.ID = id++;
        this.Title = title;
        this.Description = description;
        this.Date = date;
    }

    @Override
    public String toString() {
        return  "News {" +
                " title='" + Title + '\'' +
                ",description='" + Description + '\'' +
                ", date='" + Date + '\'' +
                '}';
    }
}
