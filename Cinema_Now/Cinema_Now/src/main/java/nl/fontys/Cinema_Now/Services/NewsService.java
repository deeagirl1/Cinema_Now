package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.Modules.News;
import nl.fontys.Cinema_Now.Interfaces.Data.INewsData;
import nl.fontys.Cinema_Now.Interfaces.Services.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {
    private INewsData data;
    @Autowired
    public NewsService(INewsData data)
    {
        this.data = data;
    }

    @Override
    public List<News> getAllNews() {
       return data.getAllNews();
    }

    @Override
    public News getANewsById(int id) {
        return data.getANewsById(id);
    }

    @Override
    public boolean createNewPost(News news) {
        return data.createNewPost(news);
    }

    @Override
    public boolean editPost(News news) {
        return data.editPost(news);
    }

    @Override
    public boolean deletePost(int id) {
        return data.deletePost(id);
    }
}
