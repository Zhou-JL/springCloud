package com.zhoujl.springcloud.service;

import com.zhoujl.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:05
 * @see: com.zhoujl.springcloud.service
 * @Version: 1.0
 */
@FeignClient(value = "seata-account-service")  //seata-account-service微服务名称
public interface AccountService{
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
