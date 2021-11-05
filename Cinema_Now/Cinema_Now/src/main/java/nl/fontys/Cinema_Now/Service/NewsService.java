package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Model.News;
import nl.fontys.Cinema_Now.DALInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.ServiceInterface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {

    private INewsDAL data;
    @Autowired
    public NewsService(INewsDAL data)
    {
        this.data = data;
    }

    @Override
    public List<News> getAllNews() {
       return data.getAllNews();
    }

    @Override
    public News getANewsById(String id) {
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
    public boolean deletePost(String id) {
        return data.deletePost(id);
    }
}
