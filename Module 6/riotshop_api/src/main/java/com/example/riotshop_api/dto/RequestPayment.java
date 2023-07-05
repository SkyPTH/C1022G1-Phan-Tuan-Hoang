package com.example.riotshop_api.dto;

public class RequestPayment {
    private Long totalPrice;

    public RequestPayment() {
    }


    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public RequestPayment(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
}
