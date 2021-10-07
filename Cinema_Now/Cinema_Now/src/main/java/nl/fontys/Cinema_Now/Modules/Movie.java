package nl.fontys.Cinema_Now.Modules;

import nl.fontys.Cinema_Now.Modules.Enums.Format;
import nl.fontys.Cinema_Now.Modules.Enums.Genre;

public class Movie  {
    private static int id = 10;
    private int ID;
    private String name;
    private Genre genre;
    private int duration;
    private String releaseDate;
    private String description;
    private Format format;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
        duration = duration;
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



   public Movie(int id,String name, Genre genre, int duration, String releaseDate, String description, Format format)
    {
        this.ID = id;
        this.name = name;
        this.genre = genre;
        this.duration= duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }
    public Movie(int id)
    {
        this.ID = id;
    }
    public Movie(String name)
    {
        this.name = name;
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
