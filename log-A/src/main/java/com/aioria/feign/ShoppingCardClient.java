package com.aioria.feign;

import com.aioria.domain.ShopingCard;
import com.aioria.domain.ShoppingItem;
import com.aioria.msg.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("log-B")
public interface ShoppingCardClient {

    @RequestMapping("/shoppingcard/{id}")
    public ShopingCard getById(@PathVariable("id") Long id);

    @RequestMapping("/shoppingcard/getByUserId")
    public ObjectRestResponse<ShopingCard> getByUserId(@RequestParam("userId") Long userId);

    @RequestMapping("/shoppingcard/items/query")
    public List<ShoppingItem> queryItems(@RequestBody ShoppingItem shoppingItem);
}
