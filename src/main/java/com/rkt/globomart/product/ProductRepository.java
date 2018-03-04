package com.rkt.globomart.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select prod from Product prod where prod.type = :type")
    List<Product> findByType(@Param("type") Product.Type type);
}
