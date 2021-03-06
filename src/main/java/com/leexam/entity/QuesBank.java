package com.leexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
    * 题库表
    */
public class QuesBank {
    /**
    * 编号
    */
    private Integer qbid;

    /**
    * 题库名称
    */
    private String qbname;

    /**
    * 题目json
    */
    private String question;

    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    /**
    * 更新时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;

    /**
    * 组织编号
    */
    private Integer oid;

    public Integer getQbid() {
        return qbid;
    }

    public void setQbid(Integer qbid) {
        this.qbid = qbid;
    }

    public String getQbname() {
        return qbname;
    }

    public void setQbname(String qbname) {
        this.qbname = qbname;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}