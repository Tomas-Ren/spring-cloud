package com.tom.springcloud.service.impl;

import com.tom.springcloud.dao.StorageDao;
import com.tom.springcloud.service.StorageServcie;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.index.qual.LengthOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StorageServcieImpl implements StorageServcie {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long id, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageDao.decrease(id, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
