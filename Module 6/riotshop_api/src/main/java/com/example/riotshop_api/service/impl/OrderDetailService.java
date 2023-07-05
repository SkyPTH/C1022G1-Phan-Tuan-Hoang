package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.OrderDetail;
import com.example.riotshop_api.repository.IOrderDetailRepository;
import com.example.riotshop_api.service.IOrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements IOrderDetail {
    @Autowired private IOrderDetailRepository iOrderDetailRepository;
    @Override
    public void createOderDetail(OrderDetail orderDetail) {
        iOrderDetailRepository.save(orderDetail);
    }

    @Override
    public List<OrderDetail> orderList(int id) {
        return iOrderDetailRepository.findOrderDetailByOrderCustomerIdOrder(id);
    }
}
