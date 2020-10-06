package com.website.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Match {

    private final UUID id;
    @NotBlank
    private String team1;
    @NotBlank
    private String team2;
    @NotBlank
    private Date date;
    @NotBlank
    private static int seatCounter = 1;

    public Match(@JsonProperty("id") UUID id,
                 @JsonProperty("team1") String team1,
                 @JsonProperty("team2") String team2,
                 @JsonProperty("date") Date date)
    {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
    }

    public int getSeatCounter()
    {
        return seatCounter;
    }

    public void increaseSeatCounter()
    {
        this.seatCounter++;
    }

    public UUID getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public Date getDate() {
        return date;
    }
}
