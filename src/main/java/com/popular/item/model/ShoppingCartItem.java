package com.popular.item.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ShoppingCartItem {
    private Product product;
    private int quantity;
}