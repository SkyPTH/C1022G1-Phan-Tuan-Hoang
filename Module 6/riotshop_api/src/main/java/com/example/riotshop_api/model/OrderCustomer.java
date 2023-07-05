package com.example.riotshop_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Entity
public class OrderCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrder;
    @Column(name = "date_order")
    @DateTimeFormat(fallbackPatterns = "dd-mm-yyyy")
    private String dateOrder;
    @Column(name = "total_price")
    private Long totalPrice;



    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_account")
    private AccountUser accountUser;
    @OneToMany(mappedBy = "orderCustomer")
    @JsonManagedReference
    private Set<OrderDetail> orderDetailSet=new TreeSet<>();

    public OrderCustomer() {
    }

    public OrderCustomer(Integer idOrder, AccountUser accountUser, Set<OrderDetail> orderDetailSet) {
        this.idOrder = idOrder;

        this.accountUser = accountUser;
        this.orderDetailSet = orderDetailSet;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }


    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }

    public Set<OrderDetail> getOrderDetailSet() {
        return orderDetailSet;
    }

    public void setOrderDetailSet(Set<OrderDetail> orderDetailSet) {
        this.orderDetailSet = orderDetailSet;
    }

}
