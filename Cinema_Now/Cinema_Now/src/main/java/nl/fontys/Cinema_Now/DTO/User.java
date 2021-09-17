package nl.fontys.Cinema_Now.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public  class User {

    private static  int id = 100;

    @Getter private int ID;
    @Getter @Setter public String firstName;
    @Getter @Setter public String lastName;
    @Getter @Setter public String email;
    @Getter @Setter public String address;
    @Getter @Setter public int age;
    // @Getter public boolean hasTicket;
  //  @Getter public List<Ticket> ticketList;
  //  @Getter public List<Complaint> complaintList;



    public User(String firstName, String lastName, String email, String address, int age)
    {
        this.ID = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
       // ticketList = new ArrayList<>();
       // complaintList = new ArrayList<>();

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
                '}';
    }

}
