package com.murdock.demo.jdbc.travel.demo.dao.dataobject;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author weipeng2k 2021年04月26日 下午14:09:50
 */
@Getter
@Setter
@ToString
public class UserDO {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名字
     */
    private String userName;
    /**
     * 花名
     */
    private String nickName;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;
    /**
     * 职位类型
     */
    private Integer type;
    /**
     * 工号
     */
    private String workNum;
    /**
     * 级别(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
     */
    private Integer level;
    /**
     * 级别类型（P,M）
     */
    private String levelType;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 电话
     */
    private String phoneNum;
    /**
     * 邮箱
     */
    private String email;
    /**
     * DingDing
     */
    private String dingTalkNo;

}
