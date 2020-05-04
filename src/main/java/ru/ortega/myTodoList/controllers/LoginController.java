package ru.ortega.myTodoList.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.ortega.myTodoList.reprs.UserRepr;
import ru.ortega.myTodoList.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    private UserService userService;

    public LoginController() {
    }

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

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
    public String registerNewUser(@ModelAttribute("user") @Valid UserRepr userRepr,
                                  BindingResult result){
        logger.info("New user {}", userRepr);

        if (result.hasErrors()){
            return "register";
        }

        if (!userRepr.getPassword().equals(userRepr.getMatchingPassword())){
            result.rejectValue("matchingPassword", "", "Passwords not matching!");
            return "register";
        }

        userService.createUser(userRepr);
        return "redirect:/login";
    }


}
