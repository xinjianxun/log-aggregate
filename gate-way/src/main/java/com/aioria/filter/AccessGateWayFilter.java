package com.aioria.filter;

import com.aioria.msg.BaseResponse;
import com.aioria.msg.auth.TokenForbiddenResponse;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

@Configuration
@Slf4j
public class AccessGateWayFilter implements GlobalFilter {
    private static final String GATE_WAY_PREFIX = "/api";
    @Value("${gate.ignore.startWith}")
    private String startWith;
    @Value("${auth.user.token-header}")
    private String tokenHeader;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        LinkedHashSet requiredAttribute = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR);
        String requestUri = request.getPath().pathWithinApplication().value();
        if (requiredAttribute != null) {
            Iterator<URI> iterator = requiredAttribute.iterator();
            while (iterator.hasNext()){
                URI next = iterator.next();
                if(next.getPath().startsWith(GATE_WAY_PREFIX)){
                    requestUri = next.getPath().substring(GATE_WAY_PREFIX.length());
                }
            }
        }
        //System.out.println(requestUri);
        ServerHttpRequest.Builder mutate = request.mutate();
        ServerHttpRequest build = mutate.build();
        /**
         * 此处处理无需验证token的url
         */
        if (isStartWith(requestUri)) {
            return chain.filter(exchange.mutate().request(build).build());
        }

        /**
         * 此处为token测试代码，项目组根据自己需求获取token并验证
         */
        try {
            List<String> strings = request.getHeaders().get(tokenHeader);
            String authToken = null;
            if (strings != null) {
                authToken = strings.get(0);
            }
            if (StringUtils.isBlank(authToken)) {
                return getVoidMono(exchange, new TokenForbiddenResponse("User Token Forbidden or Expired!"));

            }

        } catch (Exception e) {

            return getVoidMono(exchange, new TokenForbiddenResponse("User Token Forbidden or Expired!"));
        }

        return chain.filter(exchange.mutate().request(build).build());
    }

    private boolean isStartWith(String requestUri) {
        boolean flag = false;
        for (String s : startWith.split(",")) {
            if (requestUri.startsWith(s)) {
                return true;
            }
        }
        return flag;
    }

    @NotNull
    private Mono<Void> getVoidMono(ServerWebExchange serverWebExchange, BaseResponse body) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.OK);
        byte[] bytes = JSONObject.toJSONString(body).getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }


}
