package com.zhoujl.springcloud.dao;

import com.zhoujl.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 14:59
 * @see: com.zhoujl.springcloud.dao
 * @Version: 1.0
 */
@Mapper
public interface OrderDao {
    //新建订单
    void create(Order order);

    //修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
