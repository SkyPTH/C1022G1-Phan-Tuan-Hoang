package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @ModelAttribute("cart")
    public Cart setupCard(){
        return new Cart();
    }
    @GetMapping("/shop")
    public ModelAndView showShop(){
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products",iProductService.findAll());
        return modelAndView;
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,@RequestParam("action") String action,
                            @ModelAttribute Cart cart){
        Optional<Product> productOptional = iProductService.findById(id);
        if(!productOptional.isPresent()){
            return "/error.404";
        }
        if(action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
    @GetMapping("/decrease/{id}")
    public String decreaseToCart(@PathVariable int id,@ModelAttribute Cart cart){
        Optional<Product> productOptional = iProductService.findById(id);
        if(!productOptional.isPresent()){
            return "/error.404";
        } else {
            cart.decreaseProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
    }
    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(required = false) Integer id){
        ModelAndView modelAndView = new ModelAndView("/detail");
        modelAndView.addObject("product",iProductService.findByIdProDuct(id));
        return modelAndView;
    }
}
