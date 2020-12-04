package com.website.controller;

import com.website.model.FootballMatch;
import com.website.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path="/api/v1/match")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;

    @PostMapping
    public @ResponseBody String addNewMatch (@RequestBody FootballMatch newFootballMatch) {
        matchRepository.save(newFootballMatch);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<FootballMatch> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("{id}")
    public @ResponseBody
    FootballMatch getMatchById(@PathVariable int id) {
        return matchRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public @ResponseBody String updateMatch(@PathVariable int id, @RequestBody FootballMatch match) {
        FootballMatch existingMatch = matchRepository.findById(id).orElse(null);
        existingMatch.setTeam1(match.getTeam1());
        existingMatch.setTeam2(match.getTeam2());
        existingMatch.setDate(match.getDate());
        matchRepository.save(existingMatch);
        return "Match by id of " + id + " updated";
    }

    @DeleteMapping("{id}")
    public @ResponseBody String deleteMatch(@PathVariable int id) {
        matchRepository.deleteById(id);
        return "Match by id " + id + " deleted";
    }
}
