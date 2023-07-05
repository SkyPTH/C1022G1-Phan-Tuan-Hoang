package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.Cart;
import com.example.riotshop_api.model.SkinDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICartRepository extends JpaRepository<Cart,Integer> {
    @Query(value = "select * from cart where product_id_product = :idProduct ",nativeQuery = true)
    List<Cart> findCartByIdProduct(@Param("idProduct")int idProduct);
    List<Cart> findCartsByAccountUser_NameAccount(String nameAccount);
    boolean existsCartByAccountUser_IdAccountAndProduct_IdProduct(int idAccount,int idProduct);
}
