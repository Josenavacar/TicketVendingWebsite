package com.website.service;

import com.website.dao.MatchDao;
import com.website.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchDao matchDao;

    @Autowired
    public MatchService(@Qualifier("fakeDaoMatch") MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    public Integer addMatch(Match match) {
        return matchDao.insertMatch(match);
    }

    public List<Match> getAllMatches() {
        return matchDao.selectAllMatches();
    }

    public Optional<Match> getMatchById(Integer id) {
        return matchDao.selectMatchById(id);
    }

    public Integer deleteMatch(Integer id) {
        return matchDao.deleteMatchById(id);
    }

    public Integer updateMatch(Integer id, Match newMatch) {
        return matchDao.updateMatchById(id, newMatch);
    }
}
