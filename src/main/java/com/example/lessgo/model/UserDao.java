package com.example.lessgo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserDao extends JpaRepository<UserBean, Long> {
    UserBean findByPseudo(String pseudo);
    UserBean findByIdSession(String idSession);

    @Query("select new com.example.lessgo.model.UserBean(u.userId, u.pseudo, u.lat, u.lon) from UserBean u")
    ArrayList<UserBean> findAllUsersWithoutPsw();
}
