package nl.fontys.Cinema_Now.DTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class News {
    private static int id = 1;
    private int ID;
    private String title;
    private String description;
    private String date;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public News(String title, String description, String date)
    {
        this.ID = id++;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    @Override
    public String toString() {
        return  "News {" +
                " title='" + title + '\'' +
                ",description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
