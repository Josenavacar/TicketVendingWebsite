package com.website.controller;

import com.website.model.Fan;
import com.website.repository.FanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public @ResponseBody Fan getFanById(@PathVariable int id) {
        return fanRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public @ResponseBody String updateFan(@PathVariable int id, @RequestBody Fan fan) {
        Fan existingFan = fanRepository.findById(id).orElse(null);
        existingFan.setUsername(fan.getUsername());
        existingFan.setPassword(fan.getPassword());
        existingFan.setEmail(fan.getEmail());
        fanRepository.save(existingFan);
        return "Fan by id of " + id + " updated";
    }

    @DeleteMapping("{id}")
    public @ResponseBody String deleteFan(@PathVariable int id) {
        fanRepository.deleteById(id);
        return "Fan by id " + id + " deleted";
    }

}
