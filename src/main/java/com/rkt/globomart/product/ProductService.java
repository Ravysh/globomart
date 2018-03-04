package com.rkt.globomart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Value("${test.name}")
    private String name;

    public List<Product> getProducts() {
        System.out.println("==========>> "+name);
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);

        return products;
    }

    public List<Product> getProductByType(Product.Type type) {
        return productRepo.findByType(type);
    }

    public void createProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProduct(Long id) {
        productRepo.delete(id);
    }

}
