package com.aioria.domain;

import lombok.Data;

@Data
public class ShoppingItem {
    private Long id;
    private Long goodsId;
    private String goodName;
    private Double goodPrice;
    private GoodBrand goodBrand;

}
