package nl.fontys.Cinema_Now.model;

import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import org.hibernate.annotations.GenericGenerator;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name ="movies")
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

    @OneToOne
    private Room room;

    @ManyToMany()
    private Collection<Projection> projections = new ArrayList<>();

    public Movie() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull Genre getGenre() {
        return genre;
    }

    public void setGenre(@NotNull Genre genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public @NotNull String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(@NotNull String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public void setDescription(@NotNull String description) {
        this.description = description;
    }

    public @NotNull Format getFormat() {
        return format;
    }

    public void setFormat(@NotNull Format format) {
        this.format = format;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Collection<Projection> getProjections() {
        return projections;
    }

    public void setProjections(Collection<Projection> projections) {
        this.projections = projections;
    }

    public Movie(@NotNull String name, @NotNull Genre genre, int duration, @NotNull String releaseDate, @NotNull String description, @NotNull Format format)
   {

        this.name = name;
        this.genre = genre;
        this.duration= duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }
    public Movie(String id, @NotNull String name, @NotNull Genre genre, int duration, @NotNull String releaseDate, @NotNull String description, @NotNull Format format) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration= duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }

    public Movie(String id, @NotNull String name, @NotNull Genre genre, int duration, @NotNull String releaseDate, @NotNull String description, @NotNull Format format, String director, Room room, Collection<Projection> projections) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
        this.director = director;
        this.room = room;
        this.projections = projections;
    }
    public Movie(String id, @NotNull String name, @NotNull Genre genre, int duration, @NotNull String releaseDate, @NotNull String description, @NotNull Format format, String director, Room room) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
        this.director = director;
        this.room = room;

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
