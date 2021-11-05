package nl.fontys.Cinema_Now.Calculator;


import nl.fontys.Cinema_Now.Model.Ticket;


public class TicketCalculator {
    private Ticket ticket;

    public TicketCalculator(Ticket ticket) {
        this.ticket = ticket;
    }

    public double calculateTotalTicketPrice()  {
            switch (ticket.getType()) {
                case ADULT:
                    ticket.setPrice(6.99);
                    break;
                case CHILD:
                    ticket.setPrice(3.99);
                    break;
                case RETIRED:
                case STUDENT:
                    ticket.setPrice(4.99);
                    break;
            }



        return ticket.getPrice();
    }
}
