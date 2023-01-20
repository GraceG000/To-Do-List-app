package com.gracegh.ToDoList.Controller;

import com.gracegh.ToDoList.Entity.User;
import com.gracegh.ToDoList.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    /*This will display the registration page...register.html...*/
    @GetMapping("/register")
    public String registerUserPage(Model model){
        User user= new User();
        model.addAttribute("user", user);
        return "register";
    }

    /*This is for actually registering (saving) the user into the database...*/
    @PostMapping(value = "/save-user")
    public String registerUser(@Valid @ModelAttribute User user, Errors errors, Model model){
        //checking for errors in the user input...
        if(errors.hasErrors()){
            return "redirect:/register";//if the user input has errors, it will return the registration page...
        }else{
            User user1 = userService.registerUser(user);
            model.addAttribute("user", user1);
            return "login";//if the user inputs all the right details...the user's data will be saved into the database and be directed to the login page...
        }
    }

    /*This is for displaying the login page...*/
    @GetMapping("/loginPage")
    public String loginPage(Model model){
        User user= new User();
        model.addAttribute("userLogin", user);
        return "login";
    }
}
