package fontys.sem3.ticketwebsite.repository;

import fontys.sem3.ticketwebsite.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class FakeDataStore {

    private final List<Ticket> ticketList = new ArrayList<>();

    public FakeDataStore() {
        ticketList.add(new Ticket("Gregorio Mistasas", "12345678A"));
        ticketList.add(new Ticket("Frank Castle", "23456789B"));
        ticketList.add(new Ticket("John Rambo", "34567890C"));
    }


    public Ticket getTicket(int seat)
    {
        for(int i = 0; i < ticketList.stream().count(); i++)
        {
            if(ticketList.get(i).getSeat() == seat)
            {
                return ticketList.get(i);
            }
        }
        return null;
    }

    public List<Ticket> getTickets() {
        return this.ticketList;
    }
}
