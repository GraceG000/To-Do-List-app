package com.gracegh.ToDoList.Service;

import com.gracegh.ToDoList.Entity.User;
import com.gracegh.ToDoList.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    /*Performing dependency injection...*/
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
