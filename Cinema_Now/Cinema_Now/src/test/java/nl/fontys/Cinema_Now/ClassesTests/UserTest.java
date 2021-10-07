package nl.fontys.Cinema_Now.ClassesTests;

import nl.fontys.Cinema_Now.Modules.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void CreateNewUserObject() {
        User user1 = new User("Johnny", "Deep","j.deep@gmail.com");
        User user2 = new User("Angelina", "Jolie","a.jolie@gmail.com");

        Assertions.assertEquals(new User("Johnny", "Deep","j.deep@gmail.com").getFirstName(), user1.getFirstName());
        Assertions.assertEquals(new User("Angelina", "Jolie","a.jolie@gmail.com").getFirstName(), user2.getFirstName());
    }
    @Test
    public void NewUser()
    {
        User user1 = new User("Johnny", "Deep","j.deep@gmail.com","Some address", 56);

        Assertions.assertEquals("Johnny",user1.getFirstName());
        Assertions.assertEquals("Deep",user1.getLastName());
        Assertions.assertEquals("Some address", user1.getAddress());
        Assertions.assertEquals("j.deep@gmail.com", user1.getEmail());
        Assertions.assertEquals(56, user1.getAge());
    }

    @Test
    public void UserInfo()
    {
        User user1 = new User("Johnny", "Deep","j.deep@gmail.com","Some address", 56);
        String info = user1.toString();
        Assertions.assertEquals(
                "User {" +
                        "fullName='" + user1.getFullName() + '\'' +
                        ", email='" + user1.getEmail() + '\'' +
                        ", address='" + user1.getAddress() + '\'' +
                        ", age='" + user1.getAge() + '\'' +
                        ", ticketList='" + user1.getTicketList() + '\'' +
                        '}',info);


    }

}



