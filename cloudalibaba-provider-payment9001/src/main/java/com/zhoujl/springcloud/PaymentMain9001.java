package com.zhoujl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-4-21 10:28
 * @see: com.zhoujl.springcloud
 * @Version: 1.0
 */
@EnableDiscoveryClient    //用于查询服务器的信息，将自己的服务信息暴露出来，供调用者查看，用于向consul或者zookeeper或Nacos作为注册中心时注册服务
@SpringBootApplication
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class, args);
    }
}
