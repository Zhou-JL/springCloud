package com.zhoujl.springcloud.controller;

import com.zhoujl.springcloud.domain.CommonResult;
import com.zhoujl.springcloud.domain.Order;
import com.zhoujl.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:06
 * @see: com.zhoujl.springcloud.controller
 * @Version: 1.0
 */
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
