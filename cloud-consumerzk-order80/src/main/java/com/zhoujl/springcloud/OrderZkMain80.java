package com.zhoujl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-15 13:36
 * @see: com.zhoujl.springcloud
 * @Version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient   //用于查询服务器的信息，将自己的服务信息暴露出来，供调用者查看，用于向consul或者zookeeper作为注册中心时注册服务
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
