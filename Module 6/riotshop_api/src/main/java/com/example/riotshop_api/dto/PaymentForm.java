package com.example.riotshop_api.dto;

import com.example.riotshop_api.model.AccountUser;

import java.util.ArrayList;
import java.util.List;

public class PaymentForm {
    private AccountUser accountUser;
    private String email;
    private String name;
    private Double priceTotal;
    private List<Integer> listCartId = new ArrayList<>();

    public PaymentForm(AccountUser accountUser, String email, String name, Double priceTotal, List<Integer> listCartId) {
        this.accountUser = accountUser;
        this.email = email;
        this.name = name;
        this.priceTotal = priceTotal;
        this.listCartId = listCartId;
    }

    public PaymentForm() {
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Double priceTotal) {
        this.priceTotal = priceTotal;
    }

    public List<Integer> getListCartId() {
        return listCartId;
    }

    public void setListCartId(List<Integer> listCartId) {
        this.listCartId = listCartId;
    }
}
