package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.FileDTO;

public interface IFileService {
    FileDTO getImageByMovieId(String id);
}
