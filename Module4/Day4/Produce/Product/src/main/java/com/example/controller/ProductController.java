package com.example.controller;

import com.example.service.IProductService;
import com.example.service.impl.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    private IProductService iProductService=new ProductService();
    @GetMapping("")
    public String list(Model model){
        model.addAttribute("list",iProductService.list());
        return "list";
    }
    @GetMapping("create")
    public String showCreateForm(Model model){

        return "create";
    }
    @GetMapping("update")
    public String showUpdateForm(){
        return "update";
    }
    @GetMapping("delete")
    public String delete(){
        return "redirect:/product";
    }
    @PostMapping("create")
    public String create(){
        return "redirect:/product";
    }
    @PostMapping("update")
    public String update(){
        return "redirect:/product";
    }


}
