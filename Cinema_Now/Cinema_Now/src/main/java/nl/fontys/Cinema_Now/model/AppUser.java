package nl.fontys.Cinema_Now.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;


@Entity @NoArgsConstructor @AllArgsConstructor
@Table(name ="users")
public  class AppUser {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name ="uuid2", strategy = "uuid2")
    @Column(length = 36)
    private @Getter @Setter String id;

    @Column(name = "firstName")
    private @Getter @Setter String firstName;

    @Column(name = "lastName")
    private @Getter @Setter String lastName;

    @Column(name="password")
    private @Getter @Setter String password;

    @Column(name = "email")
    private @Getter @Setter String email;

    @Column(name = "username")
    private @Getter @Setter String username;

    @Column(name = "address")
    private @Getter @Setter String address;

    @Column(name = "age")
    private @Getter @Setter int age;

    @Column(name = "isLoyal")
    private @Getter @Setter boolean isLoyal = false;

    @JsonIgnore
    @OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
    private @Getter @Setter Collection<Ticket> tickets = new ArrayList<>();
    @JsonIgnore
    @OneToMany(targetEntity = Complaint.class, cascade = CascadeType.ALL)
    private @Getter @Setter Collection<Complaint> complaints = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private @Getter @Setter Collection<Role> roles = new ArrayList<>();

    public AppUser(String firstName, String lastName, String email, String address, int age)
    {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.address = address;
    this.age = age;
    }

    public AppUser(String id, String firstName, String lastName, String email, String address, int age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.age = age;

    }

    public AppUser(String firstName, String lastName, String email, String username, String address, int age,String password,Collection<Role> roles)
    {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.address = address;
        this.age = age;
        this.password = password;
        this.roles = roles;

    }

    public AppUser(String username, String firstName, String lastName, String password, Collection<Role> roles)
    {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.roles = roles;


    }

}
