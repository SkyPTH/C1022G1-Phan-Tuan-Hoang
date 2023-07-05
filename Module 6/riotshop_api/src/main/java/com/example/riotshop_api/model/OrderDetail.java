package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrderDetail;
    @Column(name = "price_product")
    private Long priceProduct;
    @ManyToOne
    @JoinColumn(columnDefinition = "id_product")
    private Product product;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(columnDefinition = "id_order")
    private OrderCustomer orderCustomer;

    public OrderDetail() {
    }

    public OrderDetail(Integer idOrderDetail, Long priceProduct, Product product, OrderCustomer orderCustomer) {
        this.idOrderDetail = idOrderDetail;

        this.priceProduct = priceProduct;
        this.product = product;
        this.orderCustomer = orderCustomer;
    }

    public Integer getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(Integer idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
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

    public OrderCustomer getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(OrderCustomer orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

}
