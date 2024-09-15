package com.sjala.ecomproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjala.ecomproj.model.LoginUser;

@Repository
public interface UserRepo extends JpaRepository<LoginUser, Integer> {

    LoginUser findByUsername(String username);
}
