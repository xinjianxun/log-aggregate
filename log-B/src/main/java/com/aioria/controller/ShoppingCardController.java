package com.aioria.controller;

import com.aioria.domain.GoodBrand;
import com.aioria.domain.ShopingCard;
import com.aioria.domain.ShoppingItem;
import com.aioria.msg.BaseResponse;
import com.aioria.msg.ObjectRestResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shoppingcard")
public class ShoppingCardController {
    @GetMapping("/{id}")
    public ShopingCard getById(@PathVariable Long id) {
        ShopingCard shopingCard = null;
        shopingCard = this.createShoppingcard(id,1L);
        return shopingCard;
    }

    @GetMapping("/getByUserId")
    public BaseResponse getByUserId(@RequestParam("userId") Long userId) {
        ShopingCard shopingCard = null;
        shopingCard = this.createShoppingcard(1L,userId);
        try{
            //Thread.sleep(10000);
        }catch(Exception e) {

        }

        return new ObjectRestResponse<ShopingCard>().data(shopingCard).rel(true);
    }


    @RequestMapping("/items/query")
    public List<ShoppingItem> queryItems(@RequestBody ShoppingItem shoppingItem) {
        List<ShoppingItem> items = this.createShoppingItems();
        List<ShoppingItem> newItems = items.stream().filter(x->x.getGoodName().contains(shoppingItem.getGoodName())).collect(Collectors.toList());
        return newItems;

    }



    private ShopingCard createShoppingcard(Long id,Long userId) {
        ShopingCard shopingCard = new ShopingCard();

        shopingCard.setId(id);
        shopingCard.setUserId(userId);

        GoodBrand goodBrand1 = new GoodBrand();
        goodBrand1.setId(1L);
        goodBrand1.setGoodBrandName("NIKE品牌");

        GoodBrand goodBrand2 = new GoodBrand();
        goodBrand2.setId(2L);
        goodBrand2.setGoodBrandName("Adidas");

        ShoppingItem item1 = new ShoppingItem();
        item1.setId(1L);
        item1.setGoodsId(1L);
        item1.setGoodName("詹姆斯10代");
        item1.setGoodPrice(1199.00);
        item1.setGoodBrand(goodBrand1);


        ShoppingItem item2 = new ShoppingItem();
        item2.setId(2L);
        item2.setGoodsId(2L);
        item2.setGoodName("Yeezy 350");
        item2.setGoodPrice(3800.00);
        item2.setGoodBrand(goodBrand2);


        List<ShoppingItem> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        shopingCard.setShoppingItems(items);

        return shopingCard;
    }

    private List<ShoppingItem> createShoppingItems() {
        List<ShoppingItem> items = new ArrayList<>();


        GoodBrand goodBrand1 = new GoodBrand();
        goodBrand1.setId(1L);
        goodBrand1.setGoodBrandName("NIKE品牌");

        GoodBrand goodBrand2 = new GoodBrand();
        goodBrand2.setId(2L);
        goodBrand2.setGoodBrandName("Adidas");

        ShoppingItem item1 = new ShoppingItem();
        item1.setId(1L);
        item1.setGoodsId(1L);
        item1.setGoodName("詹姆斯10代");
        item1.setGoodPrice(1199.00);
        item1.setGoodBrand(goodBrand1);


        ShoppingItem item2 = new ShoppingItem();
        item2.setId(2L);
        item2.setGoodsId(2L);
        item2.setGoodName("Yeezy 350");
        item2.setGoodPrice(3800.00);
        item2.setGoodBrand(goodBrand2);

        ShoppingItem item3 = new ShoppingItem();
        item3.setId(3L);
        item3.setGoodsId(3L);
        item3.setGoodName("Yeezy 550");
        item3.setGoodPrice(2455.00);
        item3.setGoodBrand(goodBrand2);

        items.add(item1);
        items.add(item2);
        items.add(item3);


        return items;
    }
}
