package com.ars.testgateway.controller.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "用户信息统计")
@Data
public class DemoArrayResponse<DemoResponseVo> {

    @ApiModelProperty(value = "每个区域的用户数据")
    private List<DemoResponseVo> userInfo;
}
