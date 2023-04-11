package com.example.cart.model;

import com.example.cart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> map = new HashMap<>();

    public Cart() {
    }

    public Map<Product, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Product, Integer> map) {
        this.map = map;
    }
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : map.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItemInCart(Product product){
        for (Map.Entry<Product,Integer> entry : map.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            map.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            map.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void decreaseProduct(Product product){
        if (!checkItemInCart(product)){
            map.put(product,1);
        } else if (map.get(product)==0) {
            map.remove(product);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            map.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return map.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : map.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}