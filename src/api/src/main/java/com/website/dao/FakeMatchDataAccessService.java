package com.website.dao;

import com.website.model.Fan;
import com.website.model.Match;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository("fakeDaoMatch")
public class FakeMatchDataAccessService implements MatchDao {

    private static List<Match> MatchDB = new ArrayList<>();


    @Override
    public int insertMatch(Integer id, String team1, String team2, String date) {

        for(int i = 0; i < MatchDB.size(); i++)
        {
            if(MatchDB.get(i).getId() == id)
            {
                return 0;
            }
        }

        MatchDB.add(new Match(team1, team2, date));
        return 1;
    }

    @Override
    public List<Match> selectAllMatches() {
        return MatchDB;
    }

    @Override
    public Optional<Match> selectMatchById(Integer id) {
        return MatchDB.stream().filter(match -> match.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteMatchById(Integer id) {
        Optional<Match> matchMaybe = selectMatchById(id);
        if(matchMaybe.isEmpty())
        {
            return 0;
        }
        else
        {
            MatchDB.remove(matchMaybe.get());
            return 1;
        }
    }

    @Override
    public int updateMatchById(Integer id, Match updated) {
        return selectMatchById(id)
                .map(match -> {
                    int indexOfMatchToUpdate = MatchDB.indexOf(match);
                    if(indexOfMatchToUpdate >= 0) {
                        MatchDB.set(indexOfMatchToUpdate, new Match(updated.getTeam1(), updated.getTeam2(), updated.getDate()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
