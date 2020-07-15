package com.tom.springcloud.servcie.impl;

import com.tom.springcloud.dao.OrderDao;
import com.tom.springcloud.domain.Order;
import com.tom.springcloud.servcie.AccountServcie;
import com.tom.springcloud.servcie.OrderServcie;
import com.tom.springcloud.servcie.StorageServcie;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServcieImpl implements OrderServcie {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageServcie storageServcie;
    @Autowired
    private AccountServcie accountServcie;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("----->订单创建完成，调用库存，做库存扣减");
        storageServcie.decrease(order.getProductId(), order.getCount());

        log.info("----->库存扣减完成，调用账户，做余额扣减");
        accountServcie.decrease(order.getUserId(), order.getMoney());

        int i = 1 / 0;

        log.info("----->金额扣减完成，修改账单状态，从0到1，表示订单完成");
        orderDao.update(order.getId(), 0);

        log.info("----->订单完成");
    }
}
