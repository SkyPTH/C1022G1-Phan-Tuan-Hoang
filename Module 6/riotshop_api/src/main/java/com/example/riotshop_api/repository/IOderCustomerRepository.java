package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOderCustomerRepository extends JpaRepository<OrderCustomer,Integer> {
    OrderCustomer findByIdOrder(int id);
    List<OrderCustomer> findAll();

    List<OrderCustomer> findOrderCustomerByAccountUser_NameAccount(String name);
    @Query(value = "select count(id_order) from oder_customer", nativeQuery = true)
    Integer getTotalCodeAmount();

}
