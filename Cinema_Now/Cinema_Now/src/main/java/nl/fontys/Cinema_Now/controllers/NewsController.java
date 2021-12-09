package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.dto.NewsDTO;
import nl.fontys.Cinema_Now.serviceInterface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NewsController {

    private final INewsService service;

    @Autowired
    public NewsController(INewsService service)
    {
        this.service=service;
    }

    //GET at /news
    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews()
    {
        List<NewsDTO> newsList = service.getAllNews();

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
    public ResponseEntity<NewsDTO> getNewsByID(@PathVariable(value = "id")  String id) {
        NewsDTO news = service.getANewsById(id);

        if(news != null) {
            return ResponseEntity.ok().body(news);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/news
    @PostMapping()
    public ResponseEntity<NewsDTO> createNewPost(@RequestBody NewsDTO news) {
        if (news == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.createNewPost(news);
            return ResponseEntity.ok().body(news);
        }

    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping("{id}")
    public ResponseEntity<NewsDTO> deletePost(@PathVariable("id") String id) {
        service.deletePost(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity<NewsDTO> updatePost(@RequestBody NewsDTO news)
    {
        if(service.editPost(news))
        {
            return ResponseEntity.ok().body(news);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}






