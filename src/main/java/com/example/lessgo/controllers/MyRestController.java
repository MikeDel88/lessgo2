package com.example.lessgo.controllers;

import com.example.lessgo.model.UserBean;
import com.example.lessgo.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyRestController {

    @Autowired
    private UserDao userDao;

    // Doit retourner la liste la liste des positions des utilisateurs équipe et autres équipe
    @GetMapping("/getPositions")
    public ArrayList<UserBean> getPositions() {
        System.out.println("/getPositions");
        return (ArrayList<UserBean>) userDao.findAllUsersWithoutPsw();
    }

}
