package nl.fontys.Cinema_Now.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.management.relation.Role;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name ="users")
public  class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

//    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @JsonIgnore
    @OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
    private Collection<String> tickets = new ArrayList<>();
    @JsonIgnore
    @OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL)
    private Collection<String> complaints = new ArrayList<>();

    public User() {

    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
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

    public Collection<String> getTicketList() {
        return tickets;
    }

    public Collection<String> getComplaints() {
        return complaints;
    }


//    public void setTicketList(Collection<Long> ticketList) {
//        this.tickets = ticketList;
//    }

//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
    public User(String firstName, String lastName, String email, String address, int age)
    {

    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.age = age;
    this.tickets = new ArrayList<>();
    this.complaints = new ArrayList<>();

    }


    public User(String id,String firstName, String lastName, String email, String address, int age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;
        this.tickets = new ArrayList<>();
        this.complaints = new ArrayList<>();

    }

//    public User(String firstName, String lastName, String email)
//    {
//
//        this.firstName = firstName;
//        this.email = email;
////        this.password = password;
//
//    }


    @Override
     public String toString() {
        return  "User {" +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", tickets='" + tickets + '\'' +
                ", complaints='" + complaints + '\'' +
                '}';
    }

}
