package com.inventorycontrol.inventorycontrol.model;

import java.time.Instant;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    @Size(min = 2,message = "name should have at least 2 characters")
    private String name;
    
    @Size(min = 5)
    private String description;
    
    @Size(min = 5)
    private String brand;
    

    private int maxQuantity;
    
    @Min(0)
    private int minQuantity;
    
    @Column(nullable = false)
    private int quantity;
    
    private double weight;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<InventoryMovement> inventoryMovements;

    @PastOrPresent
    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    @JsonIgnore
    private Instant updatedAt;
     
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getMaxQuantity() {
        return maxQuantity;
    }
    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
    public int getMinQuantity() {
        return minQuantity;
    }
    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public List<InventoryMovement> getInventoryMovements() {
        return inventoryMovements;
    }
    public void setInventoryMovements(List<InventoryMovement> inventoryMovements) {
        this.inventoryMovements = inventoryMovements;
    }    
    
    @Override
    public String toString() {
        return "Product [name=" + name + ", description=" + description + ", brand=" + brand + ", maxQuantity="
                + maxQuantity + ", minQuantity=" + minQuantity + ", quantity=" + quantity + ", weight=" + weight + "]";
    }

}
