package nl.fontys.Cinema_Now.Service;

import nl.fontys.Cinema_Now.Controller.NewsController;
import nl.fontys.Cinema_Now.Converter.NewsConverter;
import nl.fontys.Cinema_Now.DTO.NewsDTO;
import nl.fontys.Cinema_Now.Model.News;
import nl.fontys.Cinema_Now.DALInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.Model.User;
import nl.fontys.Cinema_Now.ServiceInterface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService implements INewsService {

    private INewsDAL data;
    private NewsConverter converter;
    @Autowired
    public NewsService(INewsDAL data, NewsConverter converter)
    {
        this.data = data;
        this.converter = converter;
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
    public boolean createNewPost(NewsDTO news) {
        if(news != null)
        {
            News entity = converter.dtoToEntity(news);
            data.createNewPost(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editPost(NewsDTO news) {
        if(news != null)
        {
            News entity = converter.dtoToEntity(news);
            data.editPost(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(String id) {
        return data.deletePost(id);
    }
}
