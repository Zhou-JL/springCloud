package com.zhoujl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-3-7 10:28
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RefreshScope   //对于github 上的修改实现 本地自动刷新，记得配置文件暴露端口
@RestController
public class ConfigClientController {


    // 因为config仓库以rest形式暴露，所以所有客户端都可以通过config服务端访问到github上对应的文件信息
    // 手动版本：如果要启动自动刷新 http://127.0.0.1:3355/actuator/refresh 请求POST 这个路径可以完成配置刷新
    // 自动版本，全部通知：http://127.0.0.1:3344/actuator/bus-refresh 一次请求 处处生效
    // 定点通知,http://localhost:3344/actuator/bus-refresh/config-client:3355
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo() {
        return "serverPort: " + serverPort + "\t\n\n configInfo:" + configInfo;
    }
}
