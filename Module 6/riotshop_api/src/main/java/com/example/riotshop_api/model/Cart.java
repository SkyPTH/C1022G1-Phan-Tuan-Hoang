package com.example.riotshop_api.model;

import net.minidev.json.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCart;

    @Column(name = "price_product")
    private Long priceProduct;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_product")
    @JsonIgnore
    private Product product;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_account")
    @JsonIgnore
    private AccountUser accountUser;

    public Cart(Integer idCart, Long priceProduct, Product product, AccountUser accountUser) {
        this.idCart = idCart;
        this.priceProduct = priceProduct;
        this.product = product;
        this.accountUser = accountUser;
    }

    public Cart(Long priceProduct, Product product, AccountUser accountUser) {
        this.priceProduct = priceProduct;
        this.product = product;
        this.accountUser = accountUser;
    }

    public Cart() {
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }


    public Long getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Long priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
