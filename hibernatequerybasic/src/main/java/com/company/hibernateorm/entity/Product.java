package com.company.hibernateorm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Default Constructor

    public Product() {
    }

    // Constructor

    public Product(String productName,
                   double price,
                   Category category) {

        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    // toString

    @Override
    public String toString() {
        return "Product [productId=" + productId
                + ", productName=" + productName
                + ", price=" + price
                + ", category="
                + category.getCategoryName() + "]";
    }
}