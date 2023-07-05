package com.example.riotshop_api.service;

import com.example.riotshop_api.model.OrderDetail;

import java.util.List;

public interface IOrderDetail {
    void createOderDetail(OrderDetail orderDetail);
    List<OrderDetail> orderList(int id);
}
