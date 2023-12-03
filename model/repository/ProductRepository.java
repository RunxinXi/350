package com.example.cms.model.repository;

import com.example.cms.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {



    @Query(value = "select * from products p " +
            "where lower(p.pname) like lower(concat('%', :searchTerm, '%')) ", nativeQuery = true)
    List<Product> search(@Param("searchTerm") String searchTerm);

    @Query(value = "select * from products p " +
            "where p.price <=:priceTerm" ,nativeQuery = true)
    List<Product> searchPrice(@Param("priceTerm") double priceTerm);



}