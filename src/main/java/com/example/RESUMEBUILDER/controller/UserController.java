package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.validation.UserValidator;
import com.example.RESUMEBUILDER.model.User;
import com.example.RESUMEBUILDER.service.SecurityService;
import com.example.RESUMEBUILDER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm",new User());

        return "registration";
    }

}
