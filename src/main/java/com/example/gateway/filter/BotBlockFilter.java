package com.example.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class BotBlockFilter implements GlobalFilter, Ordered {

    private static final Logger log = LoggerFactory.getLogger(BotBlockFilter.class);
    private static final List<String> BLOCKED_UA_KEYWORDS = List.of("curl", "bot", "crawler", "spider");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String userAgent = request.getHeaders().getFirst("User-Agent");

        if (userAgent != null) {
            String uaLower = userAgent.toLowerCase();
            if (BLOCKED_UA_KEYWORDS.stream().anyMatch(uaLower::contains)) {
                log.warn("Blocked bot request: {}", userAgent);
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
