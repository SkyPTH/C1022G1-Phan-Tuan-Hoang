package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.SkinDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISkinDetailRepository extends JpaRepository<SkinDetail,Integer> {
    @Query(value = "select * from skin_detail where product_id_product = :idProduct ",nativeQuery = true)
    List<SkinDetail> skinDetail(@Param("idProduct")int id);
}
