package com.tom.springcloud.domain;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class CommonResult {

    private static final int SUCCESS = 20000;   // 正常返回代码
    private static final int ERROR = 20001;     // 异常返回代码

    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private CommonResult() {};

    public static CommonResult ok(){
        CommonResult result = new CommonResult();
        result.setCode(SUCCESS);
        result.setMessage("SUCCESS");
        return result;
    }

    public static CommonResult error(){
        CommonResult result = new CommonResult();
        result.setCode(ERROR);
        result.setMessage("ERROR");
        return result;
    }


    public CommonResult code(int code){
        this.setCode(code);
        return this;
    }

    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }

    public CommonResult data(Map map){
        this.setData(map);
        return this;
    }

    public CommonResult data(String str, Object obj){
        this.data.put(str, obj);
        return this;
    }
}
