package com.ars.testgateway.core.repository;

import com.ars.testgateway.core.repository.entity.StudentDo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface StudentMapper extends Mapper<StudentDo> {

    /**
     *
     * @return 用户信息
     */
    List<StudentDo> searchUserInfo();
}
