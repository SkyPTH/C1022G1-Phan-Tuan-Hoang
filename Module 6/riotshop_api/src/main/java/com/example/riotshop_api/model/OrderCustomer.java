package com.example.riotshop_api.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class OrderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    @Column(name = "name_order")
    private String nameOrder;
    @ManyToOne
    @JoinColumn(name = "id_account")
    private AccountUser accountUser;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "order_detail", joinColumns = @JoinColumn(name = "id_account"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    Set<Product> product = new HashSet<>();

    public OrderCustomer(Integer idOrder, String nameOrder, AccountUser accountUser, Set<Product> product) {
        this.idOrder = idOrder;
        this.nameOrder = nameOrder;
        this.accountUser = accountUser;
        this.product = product;
    }

    public OrderCustomer() {
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }
}
