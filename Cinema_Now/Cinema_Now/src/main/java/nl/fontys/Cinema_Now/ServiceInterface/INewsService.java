package nl.fontys.Cinema_Now.ServiceInterface;

import nl.fontys.Cinema_Now.Model.News;

import java.util.List;

public interface INewsService {
    List<News> getAllNews();
    News getANewsById(String id);
    boolean createNewPost(News news);
    boolean editPost(News news);
    boolean deletePost(String id);
}
