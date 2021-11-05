package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.DTO.NewsDTO;
import nl.fontys.Cinema_Now.Model.News;
import java.util.List;

public interface INewsService {
    List<News> getAllNews();
    News getANewsById(String id);
    boolean createNewPost(NewsDTO news);
    boolean editPost(NewsDTO news);
    boolean deletePost(String id);
}
