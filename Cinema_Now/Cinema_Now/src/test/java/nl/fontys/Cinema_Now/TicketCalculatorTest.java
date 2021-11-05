package nl.fontys.Cinema_Now;

import nl.fontys.Cinema_Now.Calculator.TicketCalculator;
import nl.fontys.Cinema_Now.Model.Enums.TicketType;
import nl.fontys.Cinema_Now.Model.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketCalculatorTest {

    private TicketCalculator calculator;


    @Test
    public void CalculateTicketTest()
    {
        Ticket ticket = new Ticket(TicketType.ADULT,0,"05/11/2021");

        calculator = new TicketCalculator(ticket);
        Assertions.assertEquals(calculator.CalculateTotalTicketPrice(),6.99);
    }

    @Test
    public void CalculateTicketTest_TypeIsNotSet()
    {
        Ticket ticket = new Ticket(null,"05/11/2021");

        calculator = new TicketCalculator(ticket);
        Assertions.assertEquals(ticket.getPrice(),0); //to be rethought as I want to throw an exception
    }
}
