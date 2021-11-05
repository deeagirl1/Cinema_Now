package nl.fontys.Cinema_Now.Converter;

import nl.fontys.Cinema_Now.DTO.MovieDTO;
import nl.fontys.Cinema_Now.DTO.NewsDTO;
import nl.fontys.Cinema_Now.Model.Movie;
import nl.fontys.Cinema_Now.Model.News;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsConverter {

    public NewsDTO entityToDto(News news)
    {

        ModelMapper mapper = new ModelMapper();
        NewsDTO dto = mapper.map(news,NewsDTO.class);
        dto.setPostedAt(news.getPostedAt());

        return dto;

    }
    public List<NewsDTO> entityToDto(List<News> news)
    {
        return news.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

    }
    public News dtoToEntity(NewsDTO dto)
    {
        ModelMapper mapper = new ModelMapper();
        News entity = mapper.map(dto,News.class);
        entity.setPostedAt(dto.getPostedAt());
        return entity;

    }
    public List<News> dtoToEntity(List<NewsDTO> newsDTOS)
    {
        return newsDTOS.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());

    }
}
