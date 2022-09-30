package com.zhoujl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-1 14:47
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "-------------------PaymentFallbackService Fallback---------------paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-------------------PaymentFallbackService Fallback-----------paymentInfo_TimeOut";
    }
}
