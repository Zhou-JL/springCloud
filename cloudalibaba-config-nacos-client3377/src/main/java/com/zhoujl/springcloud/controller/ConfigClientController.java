package com.zhoujl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-4-21 14:25
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@RefreshScope   //实现配置的自动刷新
public class ConfigClientController {
    @Value("${config.info}")     //读取的是nacos配置中心的值,也就是配置中心上 .yaml中的值
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}

