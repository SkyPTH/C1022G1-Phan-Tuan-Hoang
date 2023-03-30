package com.example.controller;

import com.example.service.ICalculatorService;
import com.example.service.Impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private ICalculatorService iCalculatorService=new CalculatorService();
    @GetMapping("")
    public String calculator(@RequestParam(required = false, defaultValue = "") Double firstNum, Double secondNum, String operand, Model model) {
        if (firstNum == null && secondNum == null) {
            return "calculator";
        }
        double result = iCalculatorService.calculator(firstNum, secondNum, operand);
        model.addAttribute("firstNum", firstNum);
        model.addAttribute("secondNum", secondNum);
        model.addAttribute("result", result);
        return "calculator";
    }
}
