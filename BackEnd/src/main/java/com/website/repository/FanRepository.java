package com.website.repository;

import com.website.model.Fan;
import org.springframework.data.repository.CrudRepository;

public interface FanRepository extends CrudRepository<Fan, Integer> {
    Fan findById(int id);
    Fan findByUsername(String username);
}
