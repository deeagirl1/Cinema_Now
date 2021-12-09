package nl.fontys.Cinema_Now.repository;

import nl.fontys.Cinema_Now.dalInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.model.News;
import nl.fontys.Cinema_Now.repoInterfaces.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class NewsDALJPA implements INewsDAL {

    @Autowired
    INewsRepository repo;

    public NewsDALJPA(INewsRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public List<News> getAllNews() {
        return repo.findAll();
    }

    @Override
    public News getANewsById(String id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean createNewPost(News news) {
        if (news != null) {
            repo.save(news);
            return true;
        }
        return false;
    }


    @Override
    public boolean editPost(News news) {
        News updatedNewsArticle= this.getANewsById(news.getId());
        if(updatedNewsArticle != null) {
            updatedNewsArticle.setPostedAt(news.getPostedAt());
            updatedNewsArticle.setDescription(news.getDescription());
            updatedNewsArticle.setTitle(news.getTitle());
            repo.save(updatedNewsArticle);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(String id) {
        if(this.getANewsById(id) != null) {
            for (News news : repo.findAll()) {
                if (news.getId().equals(id)) {
                    repo.deleteById(id);
                    return true;
                }
            }
        }
        return false;
    }

}

