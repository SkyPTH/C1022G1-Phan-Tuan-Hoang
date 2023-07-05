package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product p " +
            "left join skin_detail sd on sd.product_id_product=p.id_product " +
            "left join skin s on s.id_skin =sd.skin_id_skin " +
            "where p.name_product like  CONCAT('%', :nameProduct, '%') " +
            "AND (p.id_rank= :idRank or :idRank='')  " +
            "AND s.name_skin like  CONCAT('%', :nameSkin, '%') " +
            "and (:minPrice = '' OR p.price >= :minPrice) " +
            "and (:maxPrice = '' OR p.price <= :maxPrice) and p.is_deleted=0 group by p.id_product"
            ,nativeQuery = true)
    Page<Product> searchProduct(@Param("nameProduct")String nameProduct,
                                @Param("idRank")String idRank,
                                @Param("nameSkin")String nameSkin,
                                @Param("minPrice")String minPrice,
                                @Param("maxPrice")String maxPrice,
                                Pageable pageable);
    Product findProductByIdProduct(int id);
}
