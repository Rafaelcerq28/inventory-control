package com.inventorycontrol.inventorycontrol.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class InventoryMovement {
    

    public InventoryMovement() {
    }
    
    public InventoryMovement(LocalDateTime dateTime, int quantity,MovementType movementType,String description, Product product) {
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.movementType = movementType;
        this.description = description;
        this.product = product;
    }
    //without description
    public InventoryMovement(LocalDateTime dateTime, int quantity,MovementType movementType, Product product) {
        this.dateTime = dateTime;
        this.quantity = quantity;
        this.movementType = movementType;
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime dateTime;
    
    @Column(nullable = false)
    private int quantity;
    
    private String description;

    private MovementType movementType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Product product;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public MovementType getMovementType() {
        return movementType;
    }
    public void setMovementType(MovementType movementType) {
        this.movementType = movementType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
