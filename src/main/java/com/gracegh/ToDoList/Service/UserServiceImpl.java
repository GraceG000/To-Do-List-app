package com.gracegh.ToDoList.Service;

import com.gracegh.ToDoList.DTO.UserDTO;
import com.gracegh.ToDoList.Entity.User;
import com.gracegh.ToDoList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /*Performing dependency injection...*/
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(UserDTO userDTO) {
       User user = new User();
       user.setFirstName(userDTO.getFirstName());
       user.setLastName(userDTO.getLastName());
       user.setEmailAddress(userDTO.getEmailAddress());

       //the code below will encrypt the password using spring security...
       user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

       if (userDTO.getPassword().equals(userDTO.getConfirmPassword())){
            userRepository.save(user);
       }
        return user;
    }
}
