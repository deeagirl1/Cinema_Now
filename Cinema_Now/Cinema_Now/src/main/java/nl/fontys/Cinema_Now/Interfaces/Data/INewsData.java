package nl.fontys.Cinema_Now.Interfaces.Data;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.News;

import java.util.List;

public interface INewsData {
    List<News> GetAllNewst();
    News GetNews(int id);
    boolean CreateNews(Complaint complaint);
}
