package com.sjala.ecomproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sjala.ecomproj.model.LoginUser;
import com.sjala.ecomproj.model.UserPrincipal;
import com.sjala.ecomproj.repo.UserRepo;

@Service
@Primary
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
    
    public LoginUser register(LoginUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
        return user;
    }
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser user = userRepo.findByUsername(username);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }
        
        return new UserPrincipal(user);
    }
}
