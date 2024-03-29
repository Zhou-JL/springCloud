package com.zhoujl.springcloud.controller;

import com.zhoujl.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-28 17:59
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(Integer id) {
        String s = paymentService.paymentInfo_OK(id);
        log.info("************result:" + s);
        return s;
    }


    /**
     * 超时的方法,模拟复杂业务
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(Integer id) {
        String s = paymentService.paymentInfo_TimeOut(id);
        log.info("************result:" + s);
        return s;
    }


    /**
     * 服务熔断
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("****result: " + result);
        return result;
    }


}
