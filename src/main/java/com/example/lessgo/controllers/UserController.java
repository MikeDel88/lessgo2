package com.example.lessgo.controllers;

import com.example.lessgo.model.UserBean;
import com.example.lessgo.model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Permet de mettre à jour la position et le pseudo d'un user
     *
     * @param userBean
     */
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/updateUser");

        UserBean u = userDao.findByIdSession(userBean.getIdSession());

        if (u == null) {
            throw new Exception("Utilisateur non trouvé");
        } else if (userBean.getLat() != null && userBean.getLon() != null) {
            if (userBean.getLat() > -90 && userBean.getLat() < 90 && userBean.getLon() > -180 && userBean.getLon() < 180) {
                u.setLat(userBean.getLat());
                u.setLon(userBean.getLon());
                userDao.save(u);
            } else {
                throw new Exception("Les cordonnées géographiques sont incorrectes.");
            }
        } else if (userBean.getPseudo() != null) {
            if (userBean.getPseudo().length() < 45){
                u.setPseudo(userBean.getPseudo());
                userDao.save(u);
            } else {
                throw new Exception("Votre pseudo doit contenir moins de 45 caractères.");
            }
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

        UserBean userBdd = userDao.findByPseudo(userBean.getPseudo());

        if (encoder.matches(userBean.getPassword(), userBdd.getPassword())) {
            String session_id = UUID.randomUUID().toString();
            userBdd.setIdSession(session_id);
            userDao.save(userBdd);
            UserBean u = new UserBean(session_id);
            return u;
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
    public UserBean registerSubmit(@RequestBody UserBean userBean) throws Exception {
        System.out.println("/registerSubmit");

        UserBean u = new UserBean();

        if (userBean.getPseudo() != null && userBean.getPassword() != null) {
            UserBean userBdd = userDao.findByPseudo(userBean.getPseudo());

            if (userBdd != null) {
                if (userBdd.getPseudo().equals(userBean.getPseudo())) {
                    throw new Exception("Ce pseudo existe déjà");
                }
            } else {
                String pswEncode = encoder.encode(userBean.getPassword());
                userBean.setPseudo(userBean.getPseudo());
                userBean.setPassword(pswEncode);
                String session_id = UUID.randomUUID().toString();
                userBean.setIdSession(session_id);
                userDao.save(userBean);
                u.setIdSession(session_id);
            }
            return u;
        } else {
            throw new Exception("Veuillez saisir vos identifiants de connexion");
        }
    }
}