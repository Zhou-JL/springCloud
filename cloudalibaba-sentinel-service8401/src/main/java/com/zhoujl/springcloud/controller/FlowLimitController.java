package com.zhoujl.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-9-30 16:04
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName()+"\t"+"...testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


    @GetMapping("/testD")
    public String testD()
    {
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");

        return "------testD";
    }


    @GetMapping("/testE")
    public String testE()
    {
        log.info("testE 异常比例");
        int age = 10/0;
        return "------testE";
    }

    @GetMapping("/testF")
    public String testF()
    {
        log.info("testF 异常数");
        int age = 10/0;
        return "------testF";
    }


    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")   //当条件满足热点配置是，走deal_testHotKey
    public String testHotKey(@RequestParam(value = "p1",required = false) String P1,@RequestParam(value = "p2",required = false) String P2){
        return "------testHotKey";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "------deal_testHotKey";
    }
}
