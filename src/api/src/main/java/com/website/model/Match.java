package com.website.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

public class Match {

    private final Integer id;
    @NotBlank
    private String team1;
    @NotBlank
    private String team2;
    @NotBlank
    private String date;
    @NotBlank
    private static int seatCounter = 1;
    private int scoreTeam1;
    private int scoreTeam0;
    private static Integer idGenerator = 0;

    public Match(@JsonProperty("team1") String team1,
                 @JsonProperty("team2") String team2,
                 @JsonProperty("date") String date)
    {
        this.id = idGenerator;
        idGenerator++;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
        this.scoreTeam0 = 0;
        this.scoreTeam1 = 0;
    }

    public int getSeatCounter()
    {
        return seatCounter;
    }

    public void increaseSeatCounter()
    {
        this.seatCounter++;
    }

    public Integer getId() {
        return id;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String newDate) { this.date = newDate; }

    public void setScoreTeam1(int newScore) { this.scoreTeam1 = newScore; }

    public int getScoreTeam1() { return this.scoreTeam1; }

    public void setScoreTeam0(int newScore) { this.scoreTeam0 = newScore; }

    public int getScoreTeam0() { return this.scoreTeam0; }
}
