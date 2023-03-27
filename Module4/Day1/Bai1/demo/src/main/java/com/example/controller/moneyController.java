package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.service.IService;
import com.example.service.Service;

@Controller
@RequestMapping("/home")
public class moneyController {
    private final IService iService = new Service();

    @GetMapping("/")
    public String test() {
        return "index.jsp";
    }
    @PostMapping ("")
    public String changeMoney(@RequestParam Double usd, Model model) {
        if (usd == null) {
            return "result";
        }
        model.addAttribute("usd",usd);
        model.addAttribute("result",iService.changeMoney(usd));
        return "result";
    }
}
