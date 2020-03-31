package com.popular.item.service;

import com.popular.item.model.Product;

import java.util.List;

public interface PopularItemService {
    public void addToList(Product product);
    public List<Product> getAllPopularProduct();
    public void deletePopularProduct(String itemId);
}
