package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public  class User {

    private static  int id = 100;

    @Getter private int ID;
    @Getter private String firstName;
    @Getter private String lastName;
    @Getter private String email;
    @Getter private String address;
    @Getter private int age;
   // @Getter private boolean hasTicket;
    @Getter private List<Ticket> ticketList;

    public User(String firstName, String lastName, String email, String address, int age)
    {
        this.ID = this.id ++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.ticketList = new ArrayList<>();
    }



    @Override
    public String toString() {
        return  "User {" +
                "firstName='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
