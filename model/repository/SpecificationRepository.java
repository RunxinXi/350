package com.example.cms.model.repository;

import com.example.cms.model.entity.Product;
import com.example.cms.model.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification, Long> {

    @Query(value = "select * from specifications p " +
            "where lower(p.pname) like lower(concat('%', :searchTerm, '%')) ", nativeQuery = true)
    List<Product> search(@Param("searchTerm") String searchTerm);
}
