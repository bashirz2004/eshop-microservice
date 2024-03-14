package com.zamani.springcloudgateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(2)
public class MyCustomGlobalPostFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerWebExchange mutatedExchange = exchange.mutate().request(exchange.getRequest()).build();
        return chain.filter(mutatedExchange).then(Mono.fromRunnable(() -> {
            exchange.getResponse().getHeaders().add("statusCode", "500");
        }));
    }
}