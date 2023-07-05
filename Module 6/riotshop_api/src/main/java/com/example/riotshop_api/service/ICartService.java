package com.example.riotshop_api.service;

import com.example.riotshop_api.dto.RequestPayment;
import com.example.riotshop_api.dto.ResponsePayment;
import com.example.riotshop_api.model.Cart;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface ICartService {
    List<Cart> findCartByIdProduct(int idProduct);
    List<Cart> findCartByNameAccount(String nameAccount);
    Cart findByIdCart(int idCart);
    void save(Cart cart);
    void deleteById(int id);
    boolean existsCartByAccountUser_IdAccountAndProduct_IdProduct(int idAccount,int idProduct);
    ResponsePayment payment(RequestPayment requestPayment) throws UnsupportedEncodingException;
}
