package com.example.lessgo.controllers;

import com.example.lessgo.model.UserBean;
import com.example.lessgo.model.UserDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MyRestController {

    @Autowired
    private UserDao userDao;

    private Gson json;

    // Doit retourner la liste la liste des positions des utilisateurs équipe et autres équipe
    @GetMapping("/getPositions")
    public String getPositions(){

            ArrayList<UserBean> users = (ArrayList<UserBean>) userDao.findAll();
            if(users.isEmpty()){
                return "test";
            }
            return json.toJson(users);
    }

}
