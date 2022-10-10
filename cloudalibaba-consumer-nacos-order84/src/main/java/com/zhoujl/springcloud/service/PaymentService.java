package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-8 17:32
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */

@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)    //PaymentFallbackService当请求中断出错的时候报里面的异常
public interface PaymentService
{
    @GetMapping(value = "/paymentSQL/{id}")     //和服务提供者的请求地址一致
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
