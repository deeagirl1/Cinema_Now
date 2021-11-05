package nl.fontys.Cinema_Now.Model;

import nl.fontys.Cinema_Now.Model.Enums.Format;
import nl.fontys.Cinema_Now.Model.Enums.Genre;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;


@Entity
@Table(name ="movie")
public class Movie  {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "genre")
    private Genre genre;

    @Column(name = "duration")
    private int duration;

    @Column(name = "releaseDate")
    private String releaseDate;

    @Column(name = "description")
    private String description;

    @Column(name = "format")
    private Format format;

    @Column(name = "director")
    private String director;
//    @Column(name = "cast")
//    private List<String> cast;

    public Movie() {

    }




    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Movie(String name, Genre genre, int duration, String releaseDate, String description, Format format)
   {

        this.name = name;
        this.genre = genre;
        this.duration= duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }
    public Movie(String id, String name, Genre genre, int duration, String releaseDate, String description, Format format) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration= duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }


    @Override
    public String toString() {

        return  "Movie {" +
                "name='" + name  + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format.toString().replace('_',' ')+ '\'' +
                '}';
    }

}
