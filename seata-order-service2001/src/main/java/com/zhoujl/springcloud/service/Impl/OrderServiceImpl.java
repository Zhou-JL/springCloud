package com.zhoujl.springcloud.service.Impl;

import com.zhoujl.springcloud.dao.OrderDao;
import com.zhoujl.springcloud.domain.CommonResult;
import com.zhoujl.springcloud.domain.Order;
import com.zhoujl.springcloud.service.AccountService;
import com.zhoujl.springcloud.service.OrderService;
import com.zhoujl.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:02
 * @see: com.zhoujl.springcloud.service.Impl
 * @Version: 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;



    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)   //name随意，不重复即可
    public void create(Order order) {
        log.info("----->开始新建订单");
        //新建订单
        orderDao.create(order);

        //扣减库存
        log.info("----->订单微服务开始调用库存，做扣减Count");
        CommonResult decrease = storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->订单微服务开始调用库存，做扣减end");

        //扣减账户
        log.info("----->订单微服务开始调用账户，做扣减Money");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->订单微服务开始调用账户，做扣减end");


        //修改订单状态，从零到1代表已经完成
        log.info("----->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("----->修改订单状态结束");

        log.info("----->下订单结束了");


    }
}
