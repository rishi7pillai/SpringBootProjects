package com.smartmanager.smartmanager.config;


import com.smartmanager.smartmanager.dao.UserRepoDao;
import com.smartmanager.smartmanager.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepoDao userOneRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo user = userOneRepo.getUserByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException("Could not found user !!" );
        }

        MyUserDetails myUserDetails = new MyUserDetails(user);

       return myUserDetails;
    }
}

