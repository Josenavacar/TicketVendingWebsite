package com.website.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer matchID;

    private String matchName;

    private String userName;

    private Integer fanID;

    private String matchDate;

    private double price = 25.99;

    private int paid;

    public double getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMatchID() {
        return matchID;
    }

    public void setMatchID(Integer matchID) {
        this.matchID = matchID;
    }

    public Integer getFanID() {
        return fanID;
    }

    public void setFanID(Integer fanID) {
        this.fanID = fanID;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public void setMatchName(String name) { this.matchName = name; }

    public String getMatchName() { return this.matchName; }

    public void setUserName(String name) { this.userName = name; }

    public String getUserName() { return this.userName; }

    public void setMatchDate(String date) {this.matchDate = date;}

    public String getMatchDate() {return this.matchDate;}
}
