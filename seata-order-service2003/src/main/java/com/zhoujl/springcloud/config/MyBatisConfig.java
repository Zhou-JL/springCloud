package com.zhoujl.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:40
 * @see: com.zhoujl.springcloud.config
 * @Version: 1.0
 */
@Configuration
@MapperScan({"com.zhoujl.springcloud.dao"})
public class MyBatisConfig {

}
