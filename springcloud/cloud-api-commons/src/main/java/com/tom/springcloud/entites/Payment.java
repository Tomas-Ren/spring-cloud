package com.tom.springcloud.entites;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("seial")
    private String serial;
}
