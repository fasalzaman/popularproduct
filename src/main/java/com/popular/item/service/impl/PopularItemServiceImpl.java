package com.popular.item.service.impl;

import com.popular.item.model.Product;
import com.popular.item.service.PopularItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PopularItemServiceImpl implements PopularItemService {

    static List<Product> productList = new ArrayList<>();

    @Override
    public void addToList(Product product){
        productList.add(product);
    }
    @Override
    public List<Product> getAllPopularProduct(){
        return  productList;
    }
    @Override
    public void deletePopularProduct(String itemId){
        Optional<Product> optionalProduct = productList.stream().filter(product -> {
            return product.getItemId().equals(itemId);
        }).findFirst();
        if(optionalProduct.isPresent()){
            productList.remove(optionalProduct.get());
        }
    }
}
