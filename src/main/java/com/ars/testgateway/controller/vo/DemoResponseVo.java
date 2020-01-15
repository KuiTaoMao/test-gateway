package com.ars.testgateway.controller.vo;

import com.ars.testgateway.core.repository.entity.StudentDo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "学生信息返回")
public class DemoResponseVo {

    @ApiModelProperty(value = "用户ID")
    private String name;

    @ApiModelProperty(value = "用户ID")
    private String sex;

    @ApiModelProperty(value = "用户ID")
    private String birthday;

    public static DemoResponseVo convertFromDo(StudentDo studentDo) {
        DemoResponseVo demoResponseVo = new DemoResponseVo();
        demoResponseVo.setName(studentDo.getName());
        demoResponseVo.setSex(studentDo.getSex());
        demoResponseVo.setBirthday(studentDo.getBirthday());

        return demoResponseVo;
    }

    public static List<DemoResponseVo> convertFromDoList(List<StudentDo> studentDoList){
        if (CollectionUtils.isEmpty(studentDoList)){
            return new ArrayList<>();
        }

        List<DemoResponseVo> demoResponseVoList = new ArrayList<>();
        for(StudentDo studentDo:studentDoList){
            DemoResponseVo demoResponseVo = convertFromDo(studentDo);
            demoResponseVoList.add(demoResponseVo);
        }
        return demoResponseVoList;
    }
}
