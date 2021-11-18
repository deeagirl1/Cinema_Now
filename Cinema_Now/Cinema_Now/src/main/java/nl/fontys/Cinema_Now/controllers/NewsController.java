package nl.fontys.Cinema_Now.controllers;

import nl.fontys.Cinema_Now.DTO.NewsDTO;
import nl.fontys.Cinema_Now.Model.News;
import nl.fontys.Cinema_Now.ServiceInterface.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/news")
public class NewsController {

    private INewsService service;

    @Autowired
    public NewsController(INewsService service)
    {
        this.service=service;
    }

    //GET at /news
    @GetMapping
    public ResponseEntity getAllNews()
    {
        List<News> newsList = null;
        newsList = service.getAllNews();

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
    public ResponseEntity getNewsByID(@PathVariable(value = "id")  String id) {
        News news = service.getANewsById(id);

        if(news != null) {
            return ResponseEntity.ok().body(news);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/news
    @PostMapping()
    public ResponseEntity createNewPost(@RequestBody NewsDTO news) {
        if (news == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            service.createNewPost(news);
            return ResponseEntity.ok().build();
        }

    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping("{id}")
    public ResponseEntity deletePost(@PathVariable("id") String id) {
        service.deletePost(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity updatePost(@RequestBody NewsDTO news)
    {
        if(service.editPost(news))
        {
            return ResponseEntity.noContent().build();
        }
        else
        {
            return new ResponseEntity("Please provide a post.",HttpStatus.NOT_FOUND);
        }
    }
}






