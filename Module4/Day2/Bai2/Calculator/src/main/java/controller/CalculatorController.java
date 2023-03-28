package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ICalculatorService;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;
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
