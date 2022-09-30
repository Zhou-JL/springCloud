package com.zhoujl.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-2 10:39
 * @see: com.zhoujl.springcloud.filter
 * @Version: 1.0
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("++++++++++++++++欢迎进入MyLogGateWayFilter ");

        List<String> uanme = exchange.getRequest().getQueryParams().get("uname");
        if (uanme == null) {
            log.info("++++++++++++++++非法用户 ");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }


    //加载过滤器顺序，数字越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
