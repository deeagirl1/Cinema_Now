package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.calculators.LoyaltyCalculator;
import nl.fontys.Cinema_Now.model.AppUser;
import nl.fontys.Cinema_Now.model.Enums.Format;
import nl.fontys.Cinema_Now.model.Enums.Genre;
import nl.fontys.Cinema_Now.model.Enums.TicketType;
import nl.fontys.Cinema_Now.model.Movie;
import nl.fontys.Cinema_Now.model.Projection;
import nl.fontys.Cinema_Now.model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class LoyaltyCalculatorTest {

    private LoyaltyCalculator calculator;

      AppUser user = new AppUser("1","Andreea","Sindrilaru","deeagirl1@gmail.com","Boschdijk 42-E",20);

      Movie movie = new Movie("1","Cars", Genre.ANIMATION, 180, "06/06/2006", "Explore Radiator Spring with Lighting McQueen and Tow Mater.", Format._3D);

      @Test
      public void AssignLoyaltyToUser_ReturnFalse()
    {
        user.getTickets().add(new Ticket(TicketType.ADULT,0,new Projection("25/05/2021","15:00", movie.getName())));
        calculator = new LoyaltyCalculator();

        Assertions.assertEquals(calculator.AssignLoyaltyToUser(user),false);

    }

    @Test
    public void AssignLoyaltyToUser_ReturnTrue()
    {
        for(int i = 1; i<=16; i++) {
            user.getTickets().add(new Ticket(TicketType.ADULT, 0, new Projection("25/05/2021", "15:00", movie.getName())));
        }

        calculator = new LoyaltyCalculator();

        Assertions.assertEquals(calculator.AssignLoyaltyToUser(user),true);

    }
}
