package com.zhoujl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-15 13:38
 * @see: com.zhoujl.springcloud.config
 * @Version: 1.0
 */
@Configuration
public class ApplicationContextConfig {

    //RestTemplate封转了httpClient,实现了远程调用
    @Bean
    @LoadBalanced    //开启负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

