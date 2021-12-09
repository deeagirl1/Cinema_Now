package nl.fontys.Cinema_Now.dalInterfaces;

import nl.fontys.Cinema_Now.model.News;
import java.util.List;

public interface INewsDAL {
    List<News> getAllNews();
    News getANewsById(String id);
    boolean createNewPost(News news);
    boolean editPost(News news);
    boolean deletePost(String id);

}
