package nl.fontys.Cinema_Now.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name ="news")
public class News {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "postedAt")
    private String postedAt;

    public News() {

    }

    public String getId() {
        return id;
    }

    public void setId(String ID) {
        this.id = ID;
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

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String date) {
        this.postedAt = date;
    }

    public News(String id, String title, String description, String date)
    {
        this.id = id;
        this.title = title;
        this.description = description;
        this.postedAt = date;
    }

    @Override
    public String toString() {
        return  "News {" +
                " title='" + title + '\'' +
                ",description='" + description + '\'' +
                ", date='" + postedAt + '\'' +
                '}';
    }
}
