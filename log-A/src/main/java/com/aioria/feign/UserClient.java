package com.aioria.feign;

import com.aioria.msg.ObjectRestResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("log-B")
public interface UserClient {
    @RequestMapping(value="/user/{id}")
    public ObjectRestResponse getUser(@PathVariable("id") Long id);

}
