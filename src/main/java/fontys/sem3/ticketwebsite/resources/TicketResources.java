package fontys.sem3.ticketwebsite.resources;

import fontys.sem3.ticketwebsite.model.Ticket;
import fontys.sem3.ticketwebsite.repository.FakeDataStore;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

@Path("/tickets")
public class TicketResources {

    @Context
    private static final FakeDataStore fakeDataStore = new FakeDataStore();

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        String msg = "Hello, this works!";
        return Response.ok(msg).build();
    }

    @GET
    @Path("{seat}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTicket(@PathParam("seat") int seat)
    {
        Ticket ticket = fakeDataStore.getTicket(seat);
        if(ticket == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Seat number incorrect or is not registered.").build();
        } else {
            return Response.ok(ticket).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTickets() {
        List<Ticket> tickets = fakeDataStore.getTickets();

        GenericEntity<List<Ticket>> entity = new GenericEntity<>(tickets) {};
        return Response.ok(entity).build();
    }

}
