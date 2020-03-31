package com.popular.item.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.popular.item.model.Product;
import com.popular.item.model.ShoppingCartItem;
import com.popular.item.service.PopularItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaCartConsumer {

    @Autowired
    private PopularItemService popularItemService;

    @KafkaListener(topics = "cart", groupId = "group-id")
    public void consume(String message) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ShoppingCartItem shoppingCartItem = mapper.readValue(message, ShoppingCartItem.class);
        popularItemService.addToList(shoppingCartItem.getProduct());
    }
}
