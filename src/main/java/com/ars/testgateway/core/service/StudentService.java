package com.ars.testgateway.core.service;

import com.ars.testgateway.controller.vo.DemoArrayResponse;
import com.ars.testgateway.controller.vo.DemoResponseVo;
import com.ars.testgateway.core.repository.StudentMapper;
import com.ars.testgateway.core.repository.entity.StudentDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

/**
 * 类名称: StudentService
 * 类描述:
 * @author maokt
 * @since 2019/11/06
 */
@SuppressWarnings("UnstableApiUsage")
@Slf4j
@Service
public class StudentService {

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentMapper studentMapper){
        this.studentMapper = studentMapper;
    }

    public DemoArrayResponse<DemoResponseVo> getUserInfo() {
        DemoArrayResponse<DemoResponseVo> userInfoList  = new DemoArrayResponse<>();

        List<StudentDo> studentDo = this.studentMapper.searchUserInfo();
        userInfoList.setUserInfo(DemoResponseVo.convertFromDoList(studentDo));

        return userInfoList;
    }

    public void Test() {
        StudentDo studentDo = new StudentDo();

        Field[] fields = studentDo.getClass().getDeclaredFields();
        System.out.println(fields);
    }
}
