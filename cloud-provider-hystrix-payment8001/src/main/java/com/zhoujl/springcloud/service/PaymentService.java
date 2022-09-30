package com.zhoujl.springcloud.service;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-2-28 17:51
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);


    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);

}
