package nl.fontys.Cinema_Now.Interfaces.Services;

import nl.fontys.Cinema_Now.Modules.News;

import java.util.List;

public interface INewsService {
    List<News> getAllNews();
    News getANewsById(int id);
    boolean createNewPost(News news);
    boolean editPost(News news);
    boolean deletePost(int id);
}
