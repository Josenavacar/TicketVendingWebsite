package com.website.dao;

import com.website.model.Fan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDaoFan")
public class FakeFanDataAccessService implements FanDao {

    private static List<Fan> FanDB = new ArrayList<>();


    @Override
    public int insertFan(String username, String password, String email) {

        for(int i = 0; i < FanDB.size(); i++)
        {
            if(FanDB.get(i).getUserName().equals(username))
            {
                return 0;
            }
        }

        /*if(FanDB.stream().filter(fan -> fan.getUserName().equals(username)).findFirst() != null)
        {
            return 0;
        }*/

        FanDB.add(new Fan(username, password, email));
        return 1;
    }

    @Override
    public List<Fan> selectAllFans() {
        return FanDB;
    }

    @Override
    public Optional<Fan> selectFanByUsername(String username) {
        return FanDB.stream().filter(fan -> fan.getUserName().equals(username)).findFirst();
    }

    @Override
    public int deleteFanByUsername(String username) {
        Optional<Fan> fanMaybe = selectFanByUsername(username);
        if(fanMaybe.isEmpty())
        {
            return 0;
        }
        else
        {
            FanDB.remove(fanMaybe.get());
            return 1;
        }
    }

    @Override
    public int updatePersonByUsername(String username, Fan updated) {
        return selectFanByUsername(username)
                .map(fan -> {
                    int indexOfFanToUpdate = FanDB.indexOf(fan);
                    if(indexOfFanToUpdate >= 0) {
                        FanDB.set(indexOfFanToUpdate, new Fan(updated.getUserName(), updated.getPassword(), updated.getEmail()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
