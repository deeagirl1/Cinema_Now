package nl.fontys.Cinema_Now.Logic;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IMovieManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieManager implements IMovieManager {
    private IMovieData movieData;


    @Autowired
    public MovieManager(IMovieData movieData)
    {
        this.movieData = movieData;
    }


}


