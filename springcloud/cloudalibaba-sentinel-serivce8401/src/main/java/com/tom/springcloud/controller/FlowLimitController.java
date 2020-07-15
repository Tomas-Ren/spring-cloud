package com.tom.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.sun.deploy.security.BlockedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
//        try {
//            Thread.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        System.out.println("---testB");
        return "----testB";
    }


    @GetMapping("/testD")
    public String testD() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testD");
        return "----D";
    }

    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey", blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "----testHotkey";
    }
    public String deal_testHotkey (String p1, String p2, BlockedException exception) {
        return "----deal_testHotkey";
    }
}
