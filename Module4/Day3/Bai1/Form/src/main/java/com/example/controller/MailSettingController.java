package com.example.controller;

import com.example.model.MailSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail-setting")
public class MailSettingController {
    @GetMapping("create")
    public String showFormCreate(Model model){
        model.addAttribute("mailSetting",new MailSetting());
        String [] language = new String[] {"English","Vietnamese","Chinese"};
        model.addAttribute("language",language);
        Integer [] pageSize=new Integer[]{5,10,25,50,75,100};
        model.addAttribute("pageSize",pageSize);
        return "form";
    }
@PostMapping("create")
    public String create(){
        return "list";
}
}
