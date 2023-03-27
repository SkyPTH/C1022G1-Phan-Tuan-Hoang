package com.example.controller;

import com.example.service.IMoneyService;
import com.example.service.MoneyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home")
public class moneyController {
    private final IMoneyService iMoneyService = new MoneyService();

    @GetMapping("")
    public String changeMoney(@RequestParam(name = "usd", defaultValue ="0") Double usd, Model model) {
        if (usd == null) {
            return "home";
        }
        model.addAttribute("usd", usd);
        model.addAttribute("result", iMoneyService.changeMoney(usd));
        return "home";
    }
}
