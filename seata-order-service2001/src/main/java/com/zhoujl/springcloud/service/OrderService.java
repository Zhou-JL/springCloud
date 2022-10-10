package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.domain.Order;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:01
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
public interface OrderService {
    void create(Order order);
}
