package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;

public class Movie {
    private  static int id = 10;
    @Getter private int ID;
    @Getter private String name;
    @Getter private Genre genre;
    @Getter private int duration;
    @Getter private String releaseDate;
    @Getter private String description;
    @Getter private Format format;

   public Movie(String name, Genre genre, int duration, String releaseDate, String description, Format format)
    {
        this.ID = this.id ++;
        this.name = name;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.description = description;
        this.format = format;
    }
    public Movie(String name)
    {
        this.id = this.ID++;
        this.name = name;
    }


    @Override
    public String toString() {

        return  "Movie {" +
//                "id =" + id +
                "name='" + name  + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                 ", format='" + format.toString() + '\'' +
                '}';
    }



}
