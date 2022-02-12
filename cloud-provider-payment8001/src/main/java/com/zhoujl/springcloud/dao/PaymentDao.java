package com.zhoujl.springcloud.dao;

import com.zhoujl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
