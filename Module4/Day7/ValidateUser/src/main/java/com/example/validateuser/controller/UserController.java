package com.example.validateuser.controller;

import com.example.validateuser.model.User;
import com.example.validateuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public String createForm(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("")
    public String create(@ModelAttribute @Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        else {
            redirectAttributes.addFlashAttribute("msg","Thêm mới thành công");
        iUserService.create(user);
        return "redirect:/user";}
    }
}
