package ru.ortega.myTodoList.controllers;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @GetMapping("/todo")
    public String todoPage(){
        return "todo";
    }

}
