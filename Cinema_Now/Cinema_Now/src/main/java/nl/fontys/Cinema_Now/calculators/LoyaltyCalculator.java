package nl.fontys.Cinema_Now.calculators;

import nl.fontys.Cinema_Now.model.AppUser;

public class LoyaltyCalculator {

    public boolean AssignLoyaltyToUser(AppUser user)
    {
        if(user.getTickets().size() >= 15)
        {
            user.setLoyal(true);
            return true;
        }
        return false;
    }
}
