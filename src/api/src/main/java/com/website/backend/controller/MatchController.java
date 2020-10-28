package com.website.controller;

import com.website.model.FootballMatch;
import com.website.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
