package com.sq.gaox.bean;

import java.util.Date;

/**
 * @author gaox
 * @description
 * @date 2019/4/10 09:35
 */
public class SysStudent {
    private long id;
    private String name;
    private int age;
    private Date createTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
