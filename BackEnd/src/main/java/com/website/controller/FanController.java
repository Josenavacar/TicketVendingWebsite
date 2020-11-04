package com.website.controller;

import com.website.model.Fan;
import com.website.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RequestMapping(path="/api/v1/fan")
public class FanController {
    @Autowired
    private FanRepository fanRepository;

    @PostMapping
    public @ResponseBody
    String addNewFan (@RequestBody Fan newFan) {
        fanRepository.save(newFan);
        return "Saved";
    }

    @GetMapping
    public @ResponseBody Iterable<Fan> getAllFans() {
        return fanRepository.findAll();
    }

}
