package com.gracegh.ToDoList.Controller;

import com.gracegh.ToDoList.Entity.User;
import com.gracegh.ToDoList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
