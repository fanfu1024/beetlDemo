package com.sq.gaox.bean;

import java.util.Date;

/**
 * @author gaox
 * @description
 * @date 2019/4/10 09:16
 */
public class SysTeacher {
    private Long id;
    private String name;
    private Integer age;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
