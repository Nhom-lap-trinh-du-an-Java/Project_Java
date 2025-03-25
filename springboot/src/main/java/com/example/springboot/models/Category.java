package com.example.springboot.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName; // Tên danh mục
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products; // Danh sách sản phẩm thuộc danh mục này

    //Constructor
    public Category() {
    }

    public Category(List<Product> products, String categoryName) {
        this.products = products;
        this.categoryName = categoryName;
    }
    //Getter and Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
