package com.example.demo.searchService.repository;

import com.example.demo.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {
    @Query("select p.productName from Product p where p.productName like CONCAT('%',:productName,'%')")
    List<Product> findByNameLike(@Param("productName") String productName);

}
