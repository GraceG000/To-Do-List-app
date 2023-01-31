package com.gracegh.ToDoList.Service;

import com.gracegh.ToDoList.Controller.CustomUserDetails;
import com.gracegh.ToDoList.Entity.User;
import com.gracegh.ToDoList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
        User user =userRepository.findByEmailAddress(emailAddress);
        if(user==null){
            throw new UsernameNotFoundException("User not found!");
        }

        return new CustomUserDetails(user);
    }
}
