package com.website;

import com.website.model.FootballMatch;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchTest {
    FootballMatch testMatch = new FootballMatch();

    @Test
    public void validateTeams() {
        testMatch.setTeam1("PSV");
        testMatch.setTeam2("Barcelona FC");
        assertThat(testMatch.getTeam1().equals("PSV") && testMatch.getTeam2().equals("Barcelona FC"));

    }

    @Test
    public void validateDate() {
        testMatch.setDate("18/11/2020");
        assertThat(testMatch.getDate().equals("18/11/2020"));
    }
}