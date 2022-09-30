package com.zhoujl.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhoujl.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-1 10:07
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {


    @Resource
    private PaymentHystrixService paymentHystrixService;


    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String s = paymentHystrixService.paymentInfo_OK(id);
        return s;
    }


    /**
     * 超时的方法,模拟复杂业务
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand   //走全局配置fallback
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            //这里调用提供者，如果提供者3秒以内返回结果走正常的业务逻辑，超过3秒走payTimeOutFallbackMethod，提供者需要两秒，就会走payTimeOutFallbackMethod
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
//    })      //走特别指定的fallback
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        int i = 10 / 0;   //这里报错走FallbackMethod
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }


    /**
     * 特别指定的fallback
     *
     * @param id
     * @return
     */
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80，对方支付系统繁忙，请10秒钟后再试，或者先自行检查！！！";
    }


    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }


}
