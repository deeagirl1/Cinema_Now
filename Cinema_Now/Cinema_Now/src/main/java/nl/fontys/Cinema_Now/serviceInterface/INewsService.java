package nl.fontys.Cinema_Now.serviceInterface;

import nl.fontys.Cinema_Now.dto.NewsDTO;
import java.util.List;

public interface INewsService {
    List<NewsDTO> getAllNews();
    NewsDTO getANewsById(String id);
    boolean createNewPost(NewsDTO news);
    boolean editPost(NewsDTO news);
    boolean deletePost(String id);
}
