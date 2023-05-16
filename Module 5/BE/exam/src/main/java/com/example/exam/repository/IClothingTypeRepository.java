package com.example.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClothingTypeRepository extends JpaRepository<ClothingType,Integer> {
    @Query(value = "select * from clothing_type",nativeQuery = true)
    List<ClothingType> findAllClothingType();

}
