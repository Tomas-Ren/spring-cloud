package com.tom.springcloud.servcie.impl;

import com.tom.springcloud.dao.AccountDao;
import com.tom.springcloud.servcie.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId, money);
    }
}
