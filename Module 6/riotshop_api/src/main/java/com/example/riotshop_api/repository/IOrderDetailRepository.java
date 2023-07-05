package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderDetailRepository extends JpaRepository<OrderDetail,Integer> {
 List<OrderDetail> findOrderDetailByOrderCustomerIdOrder(int id);
}
