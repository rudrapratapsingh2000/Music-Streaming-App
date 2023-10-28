package com.Music.repository;

import com.Music.model.AuthenticationToken;
import com.Music.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String token);


    boolean findByUser(User user);
}