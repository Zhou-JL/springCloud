package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:04
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@FeignClient(value = "seata-storage-service")    //seata-storage-service微服务名称
public interface StorageService{
    @PostMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
