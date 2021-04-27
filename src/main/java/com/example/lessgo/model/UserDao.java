package com.example.lessgo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface UserDao extends JpaRepository<UserBean, Long> {
    UserBean findByPseudo(String pseudo);
}
