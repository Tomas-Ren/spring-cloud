package com.tom.springcloud.servcie;

import com.tom.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "seata-storage-service")
public interface StorageServcie {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count);
}
