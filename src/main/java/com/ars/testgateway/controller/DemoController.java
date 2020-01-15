package com.ars.testgateway.controller;

import com.ars.paas.rosefinch.core.entity.ResultResponse;
import com.ars.testgateway.controller.vo.DemoArrayResponse;
import com.ars.testgateway.controller.vo.DemoResponseVo;
import com.ars.testgateway.core.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 类名称: DemoController
 * 类描述:
 * @author maokt
 * @since 2019/11/06
 */
@Slf4j
@RestController
@Api(value = "测试")
@RequestMapping(value = "/v1/test")
@SuppressWarnings("unused")
public class DemoController {

    @Resource
    StudentService studentService;

    @ApiOperation(value = "测试")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResultResponse<DemoArrayResponse<DemoResponseVo>> getStudentInfo(){
        DemoArrayResponse<DemoResponseVo> demoArrayResponse = this.studentService.getUserInfo();
        return new ResultResponse<>(demoArrayResponse);
    }

    @ApiOperation(value = "验证")
    @RequestMapping(value = "/timing", method = RequestMethod.GET)
    public ResultResponse<String> test(){
        this.studentService.Test();
        return new ResultResponse<>("");
    }
}

