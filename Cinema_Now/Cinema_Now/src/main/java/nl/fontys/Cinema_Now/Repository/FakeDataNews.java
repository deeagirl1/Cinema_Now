package nl.fontys.Cinema_Now.Repository;

import nl.fontys.Cinema_Now.DTO.Complaint;
import nl.fontys.Cinema_Now.DTO.News;
import nl.fontys.Cinema_Now.Interfaces.Data.INewsData;

import java.util.List;

public class FakeDataNews implements INewsData {
    @Override
    public List<News> GetAllNewst() {
        return null;
    }

    @Override
    public News GetNews(int id) {
        return null;
    }

    @Override
    public boolean CreateNews(Complaint complaint) {
        return false;
    }
}
