package nl.fontys.Cinema_Now.DTO;
import lombok.Getter;

import java.util.Date;

public class News {
    @Getter private String Title;
    @Getter private String Description;
    @Getter private Date Date;

    public News(String title, String description, Date date)
    {
        this.Title = title;
        this.Description = description;
        this.Date = date;
    }

    @Override
    public String toString() {
        return "News {" +
                "title='" + Title + '\'' +
                ",description='" + Description + '\'' +
                ", date='" + Date + '\'' +
                '}';
    }
}
