package com.website.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FootballMatch {
    private static final int MAX_SEATS = 5000;

    private static int seatCounter;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String team1;

    private String team2;

    private String date;


    public FootballMatch() {
        this.seatCounter = 0;
    }

    public int getSeatCounter() { return seatCounter; }
    public void increaseSeatCounter() { this.seatCounter++; }
    public Integer getId() { return this.id; }
    public String getTeam1() { return this.team1; }
    public String getTeam2() { return this.team2; }
    public String getDate() { return this.date; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public void setDate(String newDate) { this.date = newDate; }
}
