package net.blover.website.user.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private static Long serialVersionUID = 1L;

    private String id;

    private String name;

    private Integer age;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
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
}