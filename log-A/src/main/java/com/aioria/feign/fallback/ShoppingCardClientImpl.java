package com.aioria.feign.fallback;

import com.aioria.domain.ShopingCard;
import com.aioria.domain.ShoppingItem;
import com.aioria.feign.ShoppingCardClient;
import com.aioria.msg.ObjectRestResponse;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ShoppingCardClientImpl implements ShoppingCardClient {
    @Override
    public ShopingCard getById(Long id) {
        return null;
    }

    @Override
    public ObjectRestResponse<ShopingCard> getByUserId(Long userId) {
        ObjectRestResponse<ShopingCard> restResponse = new ObjectRestResponse<>();
        restResponse.setMessage("获取数据失败");
        restResponse.setStatus(500);
        restResponse.rel(false);
        return restResponse;
    }

    @Override
    public List<ShoppingItem> queryItems(ShoppingItem shoppingItem) {
        return null;
    }
}
