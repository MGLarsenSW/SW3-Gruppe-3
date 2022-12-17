package com.aau.gr3.controllers;

import com.aau.gr3.classes.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String getProjects(Model model) {
        return "LoginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name="user") User user, Model model){
        user.verifyLogin();
        if(user.isLoginStatus()){
            return new ProjectController().getProjects(model);
        }
        else {
            return "LoginPage";
        }
    }


}