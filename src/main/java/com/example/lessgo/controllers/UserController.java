package com.example.lessgo.controllers;

import com.example.lessgo.model.UserBean;
import com.example.lessgo.model.UserDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * Permet de mettre à jour la position et le pseudo d'un user
     *
     * @param userBean
     */
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/updateUser");

        Optional<UserBean> user = userDao.findById(userBean.getUserId());

        if (!user.isPresent()) {
            throw new Exception("User not found");
        }

        UserBean userTemp = user.get();

        if (userBean.getLat() != null && userBean.getLon() != null) {
            if (userBean.getLat() > -90 && userBean.getLat() < 90 && userBean.getLon() > -180 && userBean.getLon() < 180) {
                userTemp.setLat(userBean.getLat());
                userTemp.setLon(userBean.getLon());
            } else {
                throw new Exception("Erreur, lon et lat");
            }
            userDao.save(userTemp);
        } else {
            throw new Exception("Erreur");
        }
    }

    /**
     * Permet la connexion d'un user
     *
     * @param userBean
     * @return
     */
    //http://localhost:8080/loginSubmit
    @PostMapping("/loginSubmit")
    public UserBean loginSubmit(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/loginSubmit");

        // controle des données
        UserBean userTemp = userDao.findByPseudo(userBean.getPseudo());


        if (userTemp.getPassword().equals(userBean.getPassword())) {
            userBean = userTemp;
            return userBean;
        } else {
            throw new Exception("Erreur de connexion");
        }
    }


    /**
     * Permet l'inscription d'un user
     *
     * @param userBean
     * @return
     */
    //http://localhost:8080/registerSubmit
    @PostMapping("/registerSubmit")
    public UserBean registerSubmit(@RequestBody UserBean userBean) {
        //vérifier que le pseudo n'existe pas

        System.out.println("/registerSubmit");
        userBean.setPseudo(userBean.getPseudo());
        userBean.setPassword(userBean.getPassword());
        userDao.save(userBean);
        return userBean;
    }
}
