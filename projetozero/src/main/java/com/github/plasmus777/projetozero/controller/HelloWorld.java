package com.github.plasmus777.projetozero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello world!";
    }

    @RequestMapping("/nome")
    @ResponseBody
    public String imprimeNome(){
        return "Fernando Lopes";
    }
}
