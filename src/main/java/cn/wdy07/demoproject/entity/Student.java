package cn.wdy07.demoproject.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class Student {
    private Integer stuId;

    private String stuName;

    private String passwd;

    private Integer stuAge;

    private Boolean stuSex;


    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }

    public Boolean getStuSex() {
        return stuSex;
    }

    public void setStuSex(Boolean stuSex) {
        this.stuSex = stuSex;
    }
}