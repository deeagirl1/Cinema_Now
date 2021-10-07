package nl.fontys.Cinema_Now.Modules;

import java.util.ArrayList;
import java.util.List;

public  class User {

    private static  int id = 100;
    private int ID;
    private String firstName;
    private String lastName;
    private String fullName;
//    private String password;


    private String email;
    private String address;
    private int age;
    private List<Integer> ticketList = new ArrayList<>();

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }

    public User(String firstName, String lastName, String email, String address, int age)
    {
        this.ID = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.address = address;
        this.age = age;

    }

    public User(String firstName, String lastName, String email)
    {
        this.ID = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.email = email;
//        this.password = password;

    }


    @Override
     public String toString() {
        return  "User {" +
                "fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", ticketList='" + ticketList + '\'' +
                '}';
    }

}
