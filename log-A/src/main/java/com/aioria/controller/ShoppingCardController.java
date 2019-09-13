package com.aioria.controller;

import com.aioria.domain.ShopingCard;
import com.aioria.domain.ShoppingItem;
import com.aioria.feign.ShoppingCardClient;
import com.aioria.msg.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shoppingcard")
public class ShoppingCardController {

    @Autowired
    private ShoppingCardClient shoppingCardClient;

    @GetMapping("/{id}")
    public ShopingCard getById(@PathVariable Long id) {
        ShopingCard shopingCard = null;
        shopingCard = shoppingCardClient.getById(id);
        return shopingCard;
    }

    @GetMapping("/getByUserId")
    public BaseResponse getByUserId(@RequestParam("userId") Long userId) {

        return shoppingCardClient.getByUserId(userId);
    }

    @RequestMapping("/items/query")
    public List<ShoppingItem> queryItems(@RequestBody ShoppingItem shoppingItem) {
        return shoppingCardClient.queryItems(shoppingItem);
    }



}
