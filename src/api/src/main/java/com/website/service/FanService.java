package com.website.service;

import com.website.dao.FanDao;
import com.website.model.Fan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FanService {

    private final FanDao fanDao;

    @Autowired
    public FanService(@Qualifier("fakeDaoFan") FanDao fanDao) {
        this.fanDao = fanDao;
    }

    public int addFan(Fan fan) {
        return fanDao.insertFan(fan);
    }

    public List<Fan> getAllFans() {
        return fanDao.selectAllFans();
    }

    public Optional<Fan> getFanByUsername(String username) {
        return fanDao.selectFanByUsername(username);
    }

    public int deleteFan(String username) {
        return fanDao.deleteFanByUsername(username);
    }

    public int updateFan(String username, Fan newFan) {
        return fanDao.updatePersonByUsername(username, newFan);
    }
}
