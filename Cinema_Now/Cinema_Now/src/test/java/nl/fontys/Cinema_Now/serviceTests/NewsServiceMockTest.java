package nl.fontys.Cinema_Now.serviceTests;

import nl.fontys.Cinema_Now.converters.NewsConverter;
import nl.fontys.Cinema_Now.converters.UserConverter;
import nl.fontys.Cinema_Now.dalInterfaces.INewsDAL;
import nl.fontys.Cinema_Now.dto.NewsDTO;
import nl.fontys.Cinema_Now.dto.UserDTO;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.News;
import nl.fontys.Cinema_Now.service.NewsService;
import nl.fontys.Cinema_Now.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
public class NewsServiceMockTest {

    @Mock
    private INewsDAL newsDAL;


    @BeforeEach
    public void setUp()
    {
        List<News> news = List.of(
                new News("1","test1","test","26/02/2021"),
                new News("2","test2","test","26/02/2021"),
                new News("3","test3","test","26/02/2021")

        );


        when(newsDAL.getANewsById("1")).thenReturn(news.get(0));
        when(newsDAL.deletePost("1")).thenReturn(true);
        when(newsDAL.getAllNews()).thenReturn(news);
    }

    @Test
    public void getAllNewsTest_ReturnList()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        //act
        List<NewsDTO> news = service.getAllNews();

        //assert
        Assertions.assertEquals("1", news.get(0).getId());
        Assertions.assertEquals("2", news.get(1).getId());
        Assertions.assertEquals("3", news.get(2).getId());
    }
    @Test
    public void getNewsById()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        News news =  new News("4","test3","test","26/02/2021");
        //act
        when(newsDAL.getANewsById("4")).thenReturn(news);
        NewsDTO postToBeCheck =service.getANewsById("4");

        //assert
        Assertions.assertEquals("test3", postToBeCheck.getTitle());
    }

    @Test
    public void deletePost()
    {

        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        //act
        List<NewsDTO> news = service.getAllNews();
        var result = service.deletePost(news.get(0).getId());

        Assertions.assertEquals(result,true);

    }

    @Test
    public void addPost()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        //act
        NewsDTO news =  new NewsDTO("4","test3","test","26/02/2021");
        service.createNewPost(news);

        ArgumentCaptor<News> newsArgumentCaptor = ArgumentCaptor.forClass(News.class);

        verify(newsDAL).createNewPost(newsArgumentCaptor.capture());

        News capturePost = newsArgumentCaptor.getValue();

        Assertions.assertEquals(news.getTitle(), capturePost.getTitle());

    }

    @Test
    public void updatePost()
    {
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        //act
        NewsDTO news =  new NewsDTO("4","test3","test","26/02/2021");
        service.createNewPost(news);

        news.setTitle("Test");
        service.editPost(news);

        ArgumentCaptor<News> newsArgumentCaptor = ArgumentCaptor.forClass(News.class);

        verify(newsDAL).editPost(newsArgumentCaptor.capture());

        News capturePost = newsArgumentCaptor.getValue();

        Assertions.assertEquals(news.getTitle(), capturePost.getTitle());

    }
}
