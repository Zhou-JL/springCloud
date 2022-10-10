package com.zhoujl.springcloud.domain;

import lombok.Data;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 15:58
 * @see: com.zhoujl.springcloud.domain
 * @Version: 1.0
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}

