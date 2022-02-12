package com.zhoujl.springcloud.controller;


import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import com.zhoujl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;


    @Resource
    PaymentService paymentService;

    /**
     * 服务发现，获取服务信息
     */
    //在服务注册到注册中心eureka以后，将自己的服务信息暴露出来，供调用者查看
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result);
        if (result>0){
            return new CommonResult(200,"success****serverPort:"+serverPort,result);
        }else {
            return new CommonResult(400,"fail",null);
        }
    }


    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment.toString());
        if (payment != null){
            return new CommonResult(200,"success****serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(400,"fail",null);
        }

    }



    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("***************service:"+service);
        }

        //一个微服务下的全部实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIER-PAYMENT");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
