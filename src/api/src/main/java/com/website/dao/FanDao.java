package com.website.dao;

import com.website.model.Fan;

import java.util.List;
import java.util.Optional;

public interface FanDao {
    int insertFan(String username, String password, String email);

    default int insertFan(Fan fan) {
        return insertFan(fan.getUserName(), fan.getPassword(), fan.getEmail());
    }

    List<Fan> selectAllFans();

    Optional<Fan> selectFanByUsername(String username);

    int deleteFanByUsername(String username);

    int updatePersonByUsername(String username, Fan updated);
}
