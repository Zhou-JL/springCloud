package com.zhoujl.springcloud.service;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 16:00
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);
}
