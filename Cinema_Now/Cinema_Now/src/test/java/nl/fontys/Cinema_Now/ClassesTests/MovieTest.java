package nl.fontys.Cinema_Now.ClassesTests;

import nl.fontys.Cinema_Now.DTO.Enums.Format;
import nl.fontys.Cinema_Now.DTO.Enums.Genre;
import nl.fontys.Cinema_Now.DTO.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieTest {

    @Test
    public void CreateMovieObjectTest()
    {
        Movie movie1 = new Movie("Cruella");
        Movie movie2 = new Movie("Planet of the Apes");

        Assertions.assertEquals(new Movie("Cruella").getName(), movie1.getName());
        Assertions.assertEquals(new Movie("Planet of the Apes").getName(), movie2.getName());
    }


    @Test
    public void NewMovie()
    {
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);

        Assertions.assertEquals(1,movie1.getID());
        Assertions.assertEquals("Cars",movie1.getName());
        Assertions.assertEquals(Genre.ANIMATION,movie1.getGenre());
        Assertions.assertEquals(180, movie1.getDuration());
        Assertions.assertEquals("06/06/2006",movie1.getReleaseDate());
        Assertions.assertEquals(Format._3D, movie1.getFormat());
    }

    @Test
    public void MovieInfo()
    {
        Movie movie1 = new Movie(1,("Cars"), Genre.ANIMATION,180,"06/06/2006","Test", Format._3D);
        String info = movie1.toString();
        Assertions.assertEquals("Movie {" +
                "name='" + movie1.getName()  + '\'' +
                ", genre='" + movie1.getGenre() + '\'' +
                ", duration='" + movie1.getDuration() + '\'' +
                ", releaseDate='" + movie1.getReleaseDate() + '\'' +
                ", description='" + movie1.getDescription() + '\'' +
                ", format='" + movie1.getFormat() + '\'' +
                '}',info);


    }



}
