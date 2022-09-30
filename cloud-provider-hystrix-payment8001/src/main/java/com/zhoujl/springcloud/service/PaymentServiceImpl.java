package com.zhoujl.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-28 17:52
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    /**
     * 正常访问的方法
     *
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "paymentInfo_OK, id:  " + id + "\t" + "哈哈哈哈";
    }


    /**
     * 超时的方法,模拟复杂业务
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
            //3秒以内走正常的业务逻辑，超过3秒走paymentInfo_TimeOutHandler
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        //模拟超时
        try {
            TimeUnit.MILLISECONDS.sleep(2000);     //因为2秒在3秒的时间内，所以这里不会走 paymentInfo_TimeOutHandler
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //模拟报错
        //int age = 10/0;   //这里报错了，所以走 paymentInfo_TimeOutHandler
        System.out.println("******************");
        return "线程池：  " + Thread.currentThread().getName() + "paymentInfo_TimeOut, id:  " + id + "\t" + "哈哈哈哈：";
    }


    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池：  " + Thread.currentThread().getName() + "系统出错，请稍后再试, id:  " + id + "\t" + "(-_-)(-_-)(-_-)";
    }


    /**
     * 服务熔断 超时、异常、都会触发熔断
     * 1、默认是最近10秒内收到不小于10个请求，<br/>
     * 2、并且有60%是失败的<br/>
     * 3、就开启断路器<br/>
     * 4、开启后所有请求不再转发，降级逻辑自动切换为主逻辑，减小调用方的响应时间<br/>
     * 5、经过一段时间（时间窗口期，默认是5秒），断路器变为半开状态，会让其中一个请求进行转发。<br/>
     * &nbsp;&nbsp;5.1、如果成功，断路器会关闭，<br/>
     * &nbsp;&nbsp;5.2、若失败，继续开启。重复4和5<br/>
     *
     * @param id
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),/* 是否开启断路器*/
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),// 失败率达到多少后跳闸
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")// 超时处理
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号: " + serialNumber;
    }


    /**
     * paymentCircuitBreaker 方法的 fallback，<br/>
     * 当断路器开启时，主逻辑熔断降级，该 fallback 方法就会替换原 paymentCircuitBreaker 方法，处理请求
     *
     * @param id
     * @return
     */
    public String paymentCircuitBreakerFallback(Integer id) {
        return Thread.currentThread().getName() + "\t" + "id 不能负数或超时或自身错误，请稍后再试，/(ㄒoㄒ)/~~   id: " + id;
    }

}
