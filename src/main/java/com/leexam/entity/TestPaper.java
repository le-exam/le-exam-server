package com.leexam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
    * 试卷表
    */
public class TestPaper {
    private Integer oid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    private List<Unit> unitList;

    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    /**
    * 试卷编号
    */
    private Integer tpid;

    /**
    * 试卷名称
    */
    private String tpname;

    /**
    * 试卷描述
    */
    private String tpdesc;

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
    * 至少时间
    */
    private Integer atLeastTime;

    /**
    * 限时时间
    */
    private Integer limitTime;

    /**
    * 满分分数
    */
    private Integer fullMarks;

    /**
    * 考生须知（标题）
    */
    private String notesTitle;

    /**
    * 考试须知（内容）
    */
    private String notesBody;

    /**
    * 单元（json）
    */
    private String unit;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public String getTpname() {
        return tpname;
    }

    public void setTpname(String tpname) {
        this.tpname = tpname;
    }

    public String getTpdesc() {
        return tpdesc;
    }

    public void setTpdesc(String tpdesc) {
        this.tpdesc = tpdesc;
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

    public Integer getAtLeastTime() {
        return atLeastTime;
    }

    public void setAtLeastTime(Integer atLeastTime) {
        this.atLeastTime = atLeastTime;
    }

    public Integer getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Integer limitTime) {
        this.limitTime = limitTime;
    }

    public Integer getFullMarks() {
        return fullMarks;
    }

    public void setFullMarks(Integer fullMarks) {
        this.fullMarks = fullMarks;
    }

    public String getNotesTitle() {
        return notesTitle;
    }

    public void setNotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public String getNotesBody() {
        return notesBody;
    }

    public void setNotesBody(String notesBody) {
        this.notesBody = notesBody;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}