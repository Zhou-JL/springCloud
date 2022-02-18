package com.zhoujl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-18 13:14
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@Slf4j
public class OrderConsulController {
    //consul 上注册的服务地址
    public static final String INVOKE_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    /**
     * http://localhost/consumer/payment/consul
     * @return
     */
    @GetMapping("/consumer/payment/consul")
    public String paymentInfo() {
        //调用提供者
        return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
    }
}
