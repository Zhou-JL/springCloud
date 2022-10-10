package com.zhoujl.springcloud.service.Impl;

import com.zhoujl.springcloud.dao.StorageDao;
import com.zhoujl.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: zjl
 * @company: 北京汉唐智创科技有限公司
 * @time: 2022-10-9 16:01
 * @see: com.zhoujl.springcloud.service.Impl
 * @Version: 1.0
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger logger = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    // 扣减库存
    @Override
    public void decrease(Long productId, Integer count) {
        logger.info("------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        logger.info("------->storage-service中扣减库存结束");
    }
}

