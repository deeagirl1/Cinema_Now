package nl.fontys.Cinema_Now.Calculator;

import nl.fontys.Cinema_Now.Model.AppUser;

public class LoyalityCalculator {

    public boolean AssignLoyalityToUser(AppUser user)
    {
        if(user.getTickets().size() >= 15)
        {
            user.setLoyal(true);
            return true;
        }
        return false;
    }
}
