package com.example.exam.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IClothingsRepository extends JpaRepository<Clothings,Integer> {
    @Query(value = "select * from clothings where name like %:name% and book_type_id like %:id% order by quantity asc",nativeQuery = true)
    Page<Clothings> findByName(@Param("name") String name,@Param("id") String clothingType, Pageable pageable);
    @Query(value = "select * from clothings where id = :id",nativeQuery = true)
    Clothings findByIdClothings(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(value = "insert into clothings(code,name,clothing_type_id,date,quantity) values (:code,:name,:clothing_type_id,:date,:quantity)",nativeQuery = true)
    void saveClothings(@Param("code")String code
            ,@Param("name")String name
            ,@Param("clothing_type_id") Integer bookTypeId
            ,@Param("date")String date
            ,@Param("quantity")String quantity);
    @Modifying
    @Transactional
    @Query(value = "delete from clothings where id = :id",nativeQuery = true)
    void deleteClothings(int id);
    @Modifying
    @Transactional
    @Query(value = "update clothings set code = :code, name = :name, clothing_type_id = :clothing_type_id, date = :date, quantity = :quantity where id = :id",nativeQuery = true)
    void edit(@Param("code")String code
            ,@Param("name")String name
            ,@Param("clothing_type_id") Integer clothingTypeId
            ,@Param("date")String date
            ,@Param("quantity")String quantity
            ,@Param("id")Integer id);
}
