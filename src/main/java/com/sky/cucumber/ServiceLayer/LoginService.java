package com.sky.cucumber.ServiceLayer;

import com.sky.cucumber.DataAccessLayer.UserDao;
import com.sky.cucumber.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserDao userDao;

    private boolean isPresent;

    public boolean checkIfUserPresent(String userEmail){
        List<User> matchedUsers = userDao.findByEmail(userEmail);
        if(matchedUsers.size() > 0){
            isPresent = true;
        } else {
            isPresent = false;
        }
        return isPresent;
    }
}