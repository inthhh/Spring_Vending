package com.study.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(){
        return "main";
    }
    
    @GetMapping("/add")
    public String add(){
        return "add";
    }
    
    @GetMapping("/edit")
    public String edit(@RequestParam("index") int index) {
        
        return "edit";
    }
}
