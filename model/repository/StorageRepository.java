package com.example.cms.model.repository;

import com.example.cms.model.entity.Product;
import com.example.cms.model.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Query(value = "select * from storages s " +
            "where s.price <=:priceTerm" ,nativeQuery = true)
    List<Storage> searchStoragePrice(@Param("priceTerm") double priceTerm);


}
