package com.website.dao;

import com.website.model.Match;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MatchDao {
    int insertMatch(Integer id, String team1, String team2, String date);

    default int insertMatch(Match match) {
        return insertMatch(match.getId(), match.getTeam1(), match.getTeam2(), match.getDate());
    }

    List<Match> selectAllMatches();

    Optional<Match> selectMatchById(Integer id);

    int deleteMatchById(Integer id);

    int updateMatchById(Integer id, Match updated);
}
