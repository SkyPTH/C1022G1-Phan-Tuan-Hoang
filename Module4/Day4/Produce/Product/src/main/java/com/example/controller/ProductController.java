package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model,@RequestParam(required = false) String search ) {
        model.addAttribute("search",search);
        model.addAttribute("list", iProductService.list(search));
        return "list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findbyID(id));
        model.addAttribute("id", id);
        return "update";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        iProductService.delete(id - 1);
        return "redirect:/product";
    }

    @PostMapping("create")
    public String create(@ModelAttribute Product product) {
        iProductService.create(product);
        return "redirect:/product";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Product product) {
        int id = product.getId() - 1;
        iProductService.update(id, product);
        return "redirect:/product";
    }


}
