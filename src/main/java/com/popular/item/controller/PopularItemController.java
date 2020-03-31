package com.popular.item.controller;


import com.popular.item.model.Product;
import com.popular.item.service.PopularItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/popularitem")
public class PopularItemController {


    @Autowired
    private PopularItemService popularItemService;

    @GetMapping
    public @ResponseBody List<Product> getAll(){
        return popularItemService.getAllPopularProduct();
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable("itemId") String itemId){
         popularItemService.deletePopularProduct(itemId);
    }
}
