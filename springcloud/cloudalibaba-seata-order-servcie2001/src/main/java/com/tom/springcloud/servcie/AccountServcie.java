package com.tom.springcloud.servcie;

import com.tom.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "seata-account-service")
public interface AccountServcie {

    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long id, @RequestParam("money") BigDecimal money);
}
