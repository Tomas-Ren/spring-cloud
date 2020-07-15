package com.tom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tom.springcloud.entites.CommonResult;
import com.tom.springcloud.handler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("byResource")
    @SentinelResource(value = "byResource", blockHandler = "handlerException")
    public CommonResult byResource() {
        return CommonResult.ok().message("按照资源名称限流测试");
    }
    public CommonResult handlerException(BlockException exception){
        return CommonResult.error().message(exception.getClass().getCanonicalName() + "\t" + "服务器不可用");
    }

    @GetMapping("rateLimie/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return CommonResult.ok().message("按照资源url限流测试");
    }

    @GetMapping("rateLimie/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return CommonResult.ok().message("客户自定义");
    }
}
