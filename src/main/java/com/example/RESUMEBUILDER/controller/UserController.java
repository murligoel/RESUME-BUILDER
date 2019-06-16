package com.example.RESUMEBUILDER.controller;

import com.example.RESUMEBUILDER.validation.UserValidator;
import com.example.RESUMEBUILDER.model.User;
import com.example.RESUMEBUILDER.service.SecurityService;
import com.example.RESUMEBUILDER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public ModelAndView registration(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        modelAndView.addObject("userForm", new User());
        return modelAndView;
    }

}
