package com.example.riotshop_api.controller;

import com.example.riotshop_api.dto.CartDTO;
import com.example.riotshop_api.model.AccountUser;
import com.example.riotshop_api.model.Cart;
import com.example.riotshop_api.model.Product;
import com.example.riotshop_api.service.ICartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user/cart")
public class CartController {
    @Autowired
    private ICartService iCartService;

    @GetMapping("/findByNameAccount")
    public List<Cart> findCartByNameAccount(@RequestParam String nameAccount) {
        return iCartService.findCartByNameAccount(nameAccount);
    }
    @GetMapping("/checkExist")
    public boolean isCartExist(@RequestParam int accountID, @RequestParam int productID){
       return iCartService.existsCartByAccountUser_IdAccountAndProduct_IdProduct(accountID, productID);
    }
    @GetMapping("/findByCartID")
    public Cart findCartByCartID(@RequestParam int cartID) {
        return iCartService.findByIdCart(cartID);
    }
    @PostMapping("/create")
    public ResponseEntity<?> addCart(@Validated @RequestBody CartDTO cartDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDTO,cart);
        cart.setProduct(new Product(cartDTO.getProductId()));
        cart.setAccountUser(new AccountUser(cartDTO.getAccountUserId()));
        iCartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCart(@RequestBody Cart cart, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        if (iCartService.findByIdCart(cart.getIdCart()) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iCartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
        public ResponseEntity<?> deleteByIdCart(@RequestParam int id){
        if (iCartService.findByIdCart(id) == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        iCartService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
