package com.zhoujl.springcloud.controller;



import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import com.zhoujl.springcloud.lib.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {


//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PROVIER-PAYMENT";



    @Resource
    private RestTemplate restTemplate;



    //导入自定义的轮训机制
    @Resource
    private LoadBalancer loadBalancer;


    @Resource
    private DiscoveryClient discoveryClient;




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
     * 新增
     * @param payment
     * @return
     */
    @GetMapping("/consumer/paymententity/create")       //由于模拟的是客户端发的都是get请求
    public CommonResult<Payment> create1(Payment payment){
        log.info("**********entity新增请求*********");
        return restTemplate.postForEntity(PAYMENT_URL+"/payment/create",payment, CommonResult.class).getBody();
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


    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getentity/{id}")
    public CommonResult<Payment> getEntityPayment(@PathVariable("id") Long id){
        log.info("*********Entity获取请求*********");
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        }
        return new CommonResult<>(444,"操作失败");

    }


    /**
     * 测试自定义轮训
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLb(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIER-PAYMENT");
        if (instances == null || instances.size() <= 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
