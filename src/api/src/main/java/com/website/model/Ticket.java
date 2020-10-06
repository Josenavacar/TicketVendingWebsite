package com.website.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Ticket {

    @NotBlank
    private Match match;
    @NotBlank
    private Fan ticketOwner;
    private int row, seat;
    private boolean space = true;

    public Ticket(@JsonProperty("fan") Fan fan,
                  @JsonProperty("match") Match match)
    {
        if(space) {
            this.match = match;
            this.seat = match.getSeatCounter();
            match.increaseSeatCounter();

            this.ticketOwner = fan;

            //Check if the stadium is full
            if(match.getSeatCounter() == 30000)
            {
                space = false;
            }

            this.row = seat % 500;
        }
        else {
            this.row = -1;
            this.seat = -1;
        }
    }

    public int getSeat()
    {
        return this.seat;
    }

    public Fan getFan() { return this.ticketOwner; }

    public Match getMatch() { return this.match; }


}
