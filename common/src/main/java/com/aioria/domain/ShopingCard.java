package com.aioria.domain;

import lombok.Data;

import java.util.List;

@Data
public class ShopingCard {
    private Long id;
    private Long userId;
    List<ShoppingItem> shoppingItems;

}
