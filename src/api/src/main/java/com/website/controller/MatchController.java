package com.website.controller;

import com.website.model.Match;
import com.website.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/match")
@RestController
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public void addMatch(@Valid @NonNull @RequestBody Match match) {
        matchService.addMatch(match);
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping(path = "{id}")
    public Match getMatchById(@PathVariable("id") Integer id) {
        return matchService.getMatchById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMatchById(@PathVariable("id") Integer id) {
        matchService.deleteMatch(id);
    }

    @PutMapping(path = "{id}")
    public void updateMatch(@PathVariable("id") Integer id, @Valid @NonNull @RequestBody Match matchToUpdate) {
        matchService.updateMatch(id, matchToUpdate);
    }
}
