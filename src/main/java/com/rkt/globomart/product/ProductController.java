package com.rkt.globomart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getProducts();
    }

    @GetMapping("/products/{type}")
    public List<Product> getProductsByType(@PathVariable Product.Type type)
    {
        return productService.getProductByType(type);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product user)
    {
        productService.createProduct(user);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id)
    {
        productService.deleteProduct(id);
    }
}
