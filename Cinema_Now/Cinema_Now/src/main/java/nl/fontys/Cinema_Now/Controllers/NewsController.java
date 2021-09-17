package nl.fontys.Cinema_Now.Controllers;

import nl.fontys.Cinema_Now.DTO.Movie;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Repository.FakeDataMovies;
import nl.fontys.Cinema_Now.Repository.FakeDataNews;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/news")
public class NewsController {

    private static final FakeDataNews fakeData = new FakeDataNews();

    //GET at /news
    @GetMapping
    public ResponseEntity getAllNews()
    {
        List<News> newsList = null;
        newsList = fakeData.getAllNews();

        if(newsList != null)
        {
            return ResponseEntity.ok().body(newsList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at news/1 e…g
    @GetMapping("{id}")
    public ResponseEntity getNewsByID(@PathVariable(value = "id")  int id) {
        News news = fakeData.getANewsById(id);

        if(news != null) {
            return ResponseEntity.ok().body(news);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    //POST at http://localhost:8080/news  //works
    @PostMapping()
    public ResponseEntity<Movie> createNewPost(@RequestBody News news) {
        if (!fakeData.createNewPost(news)){
            String entity =  "New post:  " + news.getTitle()+ " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "news" + "/" + news.getID(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }
    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping()
    public ResponseEntity<News> deletePost(@RequestBody int id) {
        fakeData.deletePost(id);
        return ResponseEntity.ok().build();

    }
    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity<News> updatePost(@RequestBody News news)
    {
        if(fakeData.editPost(news))
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return new ResponseEntity("Please provide a post.",HttpStatus.NOT_FOUND);
        }
    }
}






