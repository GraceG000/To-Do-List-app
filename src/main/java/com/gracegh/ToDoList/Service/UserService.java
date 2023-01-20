package com.gracegh.ToDoList.Service;

import com.gracegh.ToDoList.DTO.UserDTO;
import com.gracegh.ToDoList.Entity.User;

public interface UserService {
    public User registerUser(UserDTO DTO);
}
