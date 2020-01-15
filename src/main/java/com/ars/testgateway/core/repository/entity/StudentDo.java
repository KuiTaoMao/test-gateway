package com.ars.testgateway.core.repository.entity;

import lombok.Data;
import javax.persistence.*;

@SuppressWarnings("unused")
@Data
@Table(name = "`tb_stu`")
public class StudentDo {

    /**
     * 自增ID
     */
    @Id
    @Column(name = "`_id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     *姓名
     */
    @Column(name = "`name`")
    private String name;

    /**
     *性别
     */
    @Column(name = "`sex`")
    private String sex;

    /**
     *生日
     */
    @Column(name = "`birthday`")
    private String birthday;

    public static final String _ID = "id";

    public static final String DB__ID = "_id";

    public static final String NAME = "name";

    public static final String DB__NAME = "name";

    public static final String SEX = "sex";

    public static final String DB__SEX = "sex";

    public static final String BIRTHDAY = "birthday";

    public static final String DB__BIRTHDAY = "birthday";

    public static StudentDo defaultInstance(){
        StudentDo instance = new StudentDo();
        return instance;
    }
}
