package nl.fontys.Cinema_Now.Repository;
import nl.fontys.Cinema_Now.Modules.Enums.TicketType;
import nl.fontys.Cinema_Now.Modules.Movie;
import nl.fontys.Cinema_Now.Modules.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IUserData;
import nl.fontys.Cinema_Now.DTO.TicketDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDataUsers implements IUserData {

    private final List<User> users = new ArrayList<>();

    FakeDataTickets tickets = new FakeDataTickets();
    public FakeDataUsers()
    {

        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        User user2 = new User("Iris", "Johnsson","i.johnsson@gmail.com","Pastor Peterstraat",20);
        Movie movie = new Movie("Avengers");
        TicketDTO ticket = new TicketDTO(TicketType.ADULT,6.99,"02/10/2021",user1.getFullName(),movie.getName());
        user1.getTicketList().add(ticket.getTicketID());
        users.add(user1);
        users.add(user2);

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserByID(int id) {
        for (User user : users)
        {
            if(user.getID() == id)
            {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        if(this.getUserByID(user.getID()) != null)
        {
            return  false;
        }
        users.add((user));
        return true;
    }

    @Override
    public boolean editUser(User user) {
        User old = this.getUserByID(user.getID());
        if(old == null)
        { return false;}
        old.setFirstName(user.getFirstName());
        old.setLastName(user.getLastName());
        old.setEmail(user.getEmail());
        old.setAddress(user.getAddress());

        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        User user = getUserByID(id);

        if(user != null)
        {
            users.remove(user);
        }

        return false;
    }

}


