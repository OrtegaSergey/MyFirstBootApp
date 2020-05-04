package ru.ortega.myTodoList.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ortega.myTodoList.reprs.UserRepr;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new UserRepr());
        return "register";
    }

    @PostMapping
    public String registerNewUser(@ModelAttribute("user") @Valid UserRepr userRepr){
        logger.info("New user {}", userRepr);
        return "redirect:/login";
    }


}
