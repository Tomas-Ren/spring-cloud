package com.tom.springcloud.controller;

import com.tom.springcloud.domain.CommonResult;
import com.tom.springcloud.service.StorageServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageServcie storageServcie;

    @PostMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long id, @RequestParam("count") Integer count){
        storageServcie.decrease(id, count);
        return CommonResult.ok();
    }
}
