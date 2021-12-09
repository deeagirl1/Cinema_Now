package nl.fontys.Cinema_Now.service;


import nl.fontys.Cinema_Now.converters.NewsConverter;
import nl.fontys.Cinema_Now.dto.NewsDTO;
import nl.fontys.Cinema_Now.model.News;
import nl.fontys.Cinema_Now.dalInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.serviceInterface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class NewsService implements INewsService {

    private final INewsDAL data;
    private final NewsConverter converter;
    @Autowired
    public NewsService(INewsDAL data, NewsConverter converter)
    {
        this.data = data;
        this.converter = converter;
    }

    @Override
    public List<NewsDTO> getAllNews() {
       return converter.entityToDto(data.getAllNews());
    }

    @Override
    public NewsDTO getANewsById(String id) {
        return converter.entityToDto(data.getANewsById(id));
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
