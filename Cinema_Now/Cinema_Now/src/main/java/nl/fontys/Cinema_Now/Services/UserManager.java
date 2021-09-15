package nl.fontys.Cinema_Now.Services;

import nl.fontys.Cinema_Now.Interfaces.Data.IUserData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserManager {
    private IUserData userData;

    @Autowired
    public UserManager(IUserData userData)
    {
        this.userData = userData;
    }

}