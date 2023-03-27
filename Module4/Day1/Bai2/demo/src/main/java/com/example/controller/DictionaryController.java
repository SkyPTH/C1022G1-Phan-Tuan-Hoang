package com.example.controller;

import com.example.service.DictionaryService;
import com.example.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    private final IDictionaryService iDictionaryService = new DictionaryService();

    @GetMapping("")
    public String translateForm() {
        return "translate";
    }

    @PostMapping("")
    public String translate(@RequestParam(name = "word") String word, Model model) {
        model.addAttribute("result", iDictionaryService.translate(word));
        if (iDictionaryService.translate(word) == null) {
            model.addAttribute("result", "Không tìm thấy từ");
        }
        return "translate";
    }
}
