package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-28 16:24
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@Component
@FeignClient(value = "CLOUD-PROVIER-PAYMENT")
public interface PaymentFeignService {


    //直接调用服务提供者8001中controller中的方法，变相的在调用8001中的service中的public Payment getPaymentById(@Param("id") Long id)  接口
    @GetMapping("/payment/get/{id}")    //eureka上服务提供者的接口请求地址
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


    //测试 OpenFeign 超时时间
    @GetMapping(value = "/payment/feign/timeout")
    public String PaymentFeignTimeout();
}
