package com.zhoujl.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhoujl.springcloud.common.CommonResult;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-8 16:24
 * @see: com.zhoujl.springcloud.myhandler
 * @Version: 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(4444, "按客户自定义....globle...handleException-----1");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(4444, "按客户自定义....globle...handleException-----2");
    }
}
