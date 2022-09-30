package com.zhoujl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-18 17:07
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@RefreshScope     //对于github 上的修改实现 本地自动刷新，记得配置文件暴露端口
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    // config.info   指的github  配置文件中的config.info 信息
    @Value("${config.info}")
    private String configInfo;


    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort:" + serverPort + "\t\n\n configInfo: " + configInfo;
//        return "serverPort:" + serverPort + "\t\n\n configInfo: " ;
    }

}

