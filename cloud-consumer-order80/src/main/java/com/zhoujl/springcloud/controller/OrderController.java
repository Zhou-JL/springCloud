package com.zhoujl.springcloud.controller;



import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {


//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PROVIER-PAYMENT";



    @Resource
    private RestTemplate restTemplate;


    /**
     * 新增
     * @param payment
     * @return
     */
    @GetMapping("/consumer/payment/create")       //由于模拟的是客户端发的都是get请求
    public CommonResult<Payment> create(Payment payment){
        log.info("**********新增请求*********");
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment, CommonResult.class);

    }



    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("*********获取请求*********");
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);

    }
}
