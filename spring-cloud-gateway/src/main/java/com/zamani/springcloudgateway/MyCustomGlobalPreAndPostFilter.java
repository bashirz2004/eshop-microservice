package com.zamani.springcloudgateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@Order(1)
public class MyCustomGlobalPreAndPostFilter implements GlobalFilter {
    public static final String CORRELATION_ID_HEADER = "correlation-id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String correlationId;
        ServerHttpRequest request = exchange.getRequest();

        if (!request.getHeaders().containsKey(CORRELATION_ID_HEADER)) {
            correlationId = UUID.randomUUID().toString();
            request = request
                    .mutate()
                    .header(CORRELATION_ID_HEADER, correlationId)
                    .build();
        } else {
            correlationId = request.getHeaders().get(CORRELATION_ID_HEADER).get(0);
        }

        ServerWebExchange mutatedExchange = exchange.mutate().request(request).build();
        String finalCorrelationId = correlationId;

        return chain.filter(mutatedExchange).then(Mono.fromRunnable(() -> {
            exchange.getResponse().getHeaders().add(CORRELATION_ID_HEADER, finalCorrelationId);
        }));
    }
}