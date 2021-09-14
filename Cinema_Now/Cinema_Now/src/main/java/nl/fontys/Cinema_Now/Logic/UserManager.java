package nl.fontys.Cinema_Now.Logic;

import nl.fontys.Cinema_Now.Interfaces.Data.IMovieData;
import nl.fontys.Cinema_Now.Interfaces.Data.IUserData;
import nl.fontys.Cinema_Now.Interfaces.Managers.IMovieManager;
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