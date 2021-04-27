package com.example.lessgo.controllers;

import com.example.lessgo.model.UserBean;
import com.example.lessgo.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/updateUser")
    public void updateUser(UserBean userBean){

        if (userBean.getLat() != null && userBean.getLon() != null){
            // update la position
        } else if (userBean.getPseudo() != null){
            // update le pseudo
        }
    }

}
