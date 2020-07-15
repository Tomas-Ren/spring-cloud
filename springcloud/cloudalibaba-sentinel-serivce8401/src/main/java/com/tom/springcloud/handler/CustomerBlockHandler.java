package com.tom.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tom.springcloud.entites.CommonResult;
import org.springframework.stereotype.Component;

@Component
public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception) {
        return CommonResult.error().message("自定义全局异常处理 1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return CommonResult.error().message("自定义全局异常处理 2");
    }
}
