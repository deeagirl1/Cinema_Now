package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.Interfaces.Data.INewsData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDataNews implements INewsData {
    private final List<News> newsList = new ArrayList<>();

    public FakeDataNews()
    {
        News container1 = new News("Lorem Ipsum", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum","15/09/2021");
        newsList.add(container1);
    }

    @Override
    public List<News> getAllNews() {
        return newsList;
    }

    @Override
    public News getANewsById(int id) {
            for (News news : newsList)
            {
                if(news.getID() == id)
                {
                    return news;
                }
            }
            return null;
    }

    @Override
    public boolean createNewPost(News news) {
        if(this.getANewsById(news.getID()) != null)
        {
            return  false;
        }
        newsList.add((news));
        return true;
    }

    @Override
    public boolean editPost(News news) {
        News old = this.getANewsById(news.getID());
        if(old == null)
        { return false;}
        old.setTitle(news.getTitle());
        old.setDescription(news.getDescription());
        old.setDate(news.getDate());

        return true;
    }

    @Override
    public boolean deletePost(int id) {
       News news = getANewsById(id);

       if(news != null)
       {
           newsList.remove(news);
       }

       return false;
    }
}
