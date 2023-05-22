package com.inventorycontrol.inventorycontrol.controller;


import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inventorycontrol.inventorycontrol.model.Product;
import com.inventorycontrol.inventorycontrol.service.ProductService;

@RestController
public class ProductController {
    
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    //save
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }
    //get all
    @GetMapping("/product")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAllProducts(){
        return productService.findAllProducts();
    }
    //get one
    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Product> findProduct(@PathVariable(value = "id") Long id){
        return productService.findProduct(id);
    }

}
