package com.zhoujl.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zjl    自定义负载均衡路由规则类
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-18 14:55
 * @see: com.zhoujl.myrule
 * @Version: 1.0
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RandomRule();
    }
}
