package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.calculators.TicketCalculator;
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
public class TicketCalculatorTest {

    private TicketCalculator calculator;

    Movie movie = new Movie("1","Cars", Genre.ANIMATION, 180, "06/06/2006", "Explore Radiator Spring with Lighting McQueen and Tow Mater.", Format._3D);

    @Test
    public void CalculateTicketTest()
    {
        Ticket ticket = new Ticket(TicketType.ADULT,0,new Projection("25/05/2021","15:00", movie.getName()));

        calculator = new TicketCalculator(ticket);
        Assertions.assertEquals(calculator.calculateTotalTicketPrice(),6.99);
    }

    @Test
    public void CalculateTicketTest_TypeIsNotSet()
    {
        Ticket ticket = new Ticket(null,new Projection("25/05/2021","15:00", movie.getName()));

        calculator = new TicketCalculator(ticket);
        Assertions.assertEquals(ticket.getPrice(),0);
    }
}
