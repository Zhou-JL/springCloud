package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.common.CommonResult;
import com.zhoujl.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-8 17:35
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
