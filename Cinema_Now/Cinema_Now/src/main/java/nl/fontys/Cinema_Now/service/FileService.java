package nl.fontys.Cinema_Now.service;

import nl.fontys.Cinema_Now.dalInterfaces.IMovieDAL;
import nl.fontys.Cinema_Now.dto.FileDTO;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.serviceInterface.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class FileService implements IFileService {

    private IMovieDAL movieDAL;

    @Autowired
    public FileService(IMovieDAL movieDAL) {
        this.movieDAL = movieDAL;
    }

    @Override
    public FileDTO getImageByMovieId(String id) {
        Movie movie = movieDAL.getMovie(id);
        FileDTO file = new FileDTO(movie.getImageName(), movie.getImageData());

        return file;
    }
}