package nl.fontys.Cinema_Now.Modules;

import java.util.Date;

public abstract class Complaint {

    private static int id = 1000;
    private int ID;
    private String title;
    private String container;
    private Date sentDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Complaint(String title, String container, Date sentDate)
    {
        this.ID = id++;
        this.title = title;
        this.container = container;
        this.sentDate = sentDate;

    }

    @Override
    public String toString() {
        return  "Complaint {" +
                "title='" + title + '\'' +
                ",description='" + container + '\'' +
                '}';
    }
}
