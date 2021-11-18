package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DALInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.Model.News;
import nl.fontys.Cinema_Now.RepoInterfaces.INewsRepository;
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
        News updatedNewsArticle= this.getANewsById(news.getID());
        updatedNewsArticle.setPostedAt(news.getPostedAt());
        updatedNewsArticle.setDescription(news.getDescription());
        updatedNewsArticle.setTitle(news.getTitle());
        repo.save(updatedNewsArticle);
        return true;
    }

    @Override
    public boolean deletePost(String id) {
        for (News news : repo.findAll()) {
            if (news.getID().equals(id)) {
                repo.deleteById(id);
                return true;
            }
        }
        return false;
    }

}

