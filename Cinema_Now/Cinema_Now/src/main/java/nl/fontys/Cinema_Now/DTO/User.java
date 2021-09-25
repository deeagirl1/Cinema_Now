package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public  class User {

    private static  int id = 100;
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private int age;
    private List<Integer> ticketList = new ArrayList<>();
    private List<Complaint> complaintList = new ArrayList<>();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Integer> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Integer> ticketList) {
        this.ticketList = ticketList;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }



    public User(String firstName, String lastName, String email, String address, int age)
    {
        this.ID = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;

    }

    public User(String firstName, String lastName)
    {
        this.ID = id++;
        this.firstName = firstName;
        this.lastName = lastName;

    }


    @Override
     public String toString() {
        return  "User {" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", ticketList='" + ticketList + '\'' +
                '}';
    }

}
