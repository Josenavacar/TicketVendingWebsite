package com.website.controller;

import com.website.model.Fan;
import com.website.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/fan")
@RestController
public class FanController {

    private final FanService fanService;

    @Autowired
    public FanController(FanService fanService) {
        this.fanService = fanService;
    }

    @PostMapping
    public void addFan(@Valid @NonNull @RequestBody Fan fan) {
        fanService.addFan(fan);
    }

    @GetMapping
    public List<Fan> getAllFans() {
        return fanService.getAllFans();
    }

    @GetMapping(path = "{username}")
    public Fan getFanByUsername(@PathVariable("username") String username) {
        return fanService.getFanByUsername(username)
                .orElse(null);
    }

    @DeleteMapping(path = "{username}")
    public void deleteFanById(@PathVariable("username") String username) {
        fanService.deleteFan(username);
    }

    @PutMapping(path = "{username}")
    public void updateFan(@PathVariable("username") String username, @Valid @NonNull @RequestBody Fan fanToUpdate) {
        fanService.updateFan(username, fanToUpdate);
    }
}
