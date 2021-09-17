package nl.fontys.Cinema_Now.Repository;
import nl.fontys.Cinema_Now.DTO.User;
import nl.fontys.Cinema_Now.Interfaces.Data.IUserData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeDataUsers implements IUserData {

    private final List<User> users = new ArrayList<>();


    public FakeDataUsers()
    {

        User user1 = new User("Anna", "Johnsson","a.johnsson@gmail.com","Pastor Peterstraat",24);
        User user2 = new User("Iris", "Johnsson","i.johnsson@gmail.com","Pastor Peterstraat",20);

        users.add(user1);
        users.add(user2);

    }

    @Override
    public List<User> GetAllUsers() {
        return users;
    }

    @Override
    public User GetUserByID(int id) {
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
    public boolean AddUser(User user) {
        if(this.GetUserByID(user.getID()) != null)
        {
            return  false;
        }
        users.add((user));
        return true;
    }

    @Override
    public boolean editUser(User user) {
        User old = this.GetUserByID(user.getID());
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
        User user = GetUserByID(id);

        if(user != null)
        {
            users.remove(user);
        }

        return false;
    }

}


