package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import lombok.Setter;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;

public class Movie  {
    //private static int id = 10;
    @Getter public int ID;
    @Getter @Setter public String name;
    @Getter @Setter public Genre genre;
    @Getter @Setter public int duration;
    @Getter @Setter public String releaseDate;
    @Getter @Setter public String description;
    @Getter @Setter public Format format;

   public Movie(int id,String name, Genre genre, int duration, String releaseDate, String description, Format format)
    {
        this.ID = id;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
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
                ", format='" + format.toString() + '\'' +
                '}';
    }



}
