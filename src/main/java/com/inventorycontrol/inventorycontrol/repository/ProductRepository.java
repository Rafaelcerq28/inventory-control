package com.inventorycontrol.inventorycontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventorycontrol.inventorycontrol.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
