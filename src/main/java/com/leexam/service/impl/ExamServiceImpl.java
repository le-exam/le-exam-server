package com.leexam.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leexam.entity.Exam;
import com.leexam.entity.Examinee;
import com.leexam.entity.Org;
import com.leexam.mapper.ExamMapper;
import com.leexam.mapper.ExamineeMapper;
import com.leexam.mapper.OrgMapper;
import com.leexam.service.ExamService;
import com.leexam.service.ExamineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/07
 */
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamMapper examMapper;
    @Autowired
    OrgMapper orgMapper;
    @Autowired
    ExamineeMapper examineeMapper;
    @Autowired
    ExamineeServiceImpl examineeService;

    @Override
    public List<Exam> selectAll() {
        return examMapper.selectAll();
    }

    @Override
    public String deleteByPrimaryKey(Integer eid) {
        return examMapper.deleteByPrimaryKey(eid) > 0 ? "success" : "error";
    }

    @Override
    public String insertSelective(Exam record) {
        try {
            examMapper.insertSelective(record);
            Org org = orgMapper.selectAllByOid(record.getOid()).get(0);
            ObjectMapper objectMapper = new ObjectMapper();
            Integer[] eids = objectMapper.readValue(org.getEids(), Integer[].class);
            Integer[] newEids = Arrays.copyOf(eids, eids.length + 1);
            newEids[newEids.length - 1] = record.getEid();
            org.setEids(objectMapper.writeValueAsString(newEids));
            orgMapper.updateEidsByOid(org);
        } catch (JsonProcessingException e) {
            return "error";
        }
        return "success";
    }

    @Override
    public Exam selectByPrimaryKey(Integer eid) {
        return examMapper.selectByPrimaryKey(eid);
    }

    @Override
    public String updateByPrimaryKeySelective(Exam record) {
        return examMapper.updateByPrimaryKeySelective(record) > 0 ? "success" : "error";
    }

    @Override
    public List<Exam> selectByOid(Integer oid) {
        List<Org> orgList = orgMapper.selectAllByOid(oid);
        Org org = orgList.get(0);
        String eidsJsonStr = org.getEids();
        ObjectMapper objectMapper = new ObjectMapper();
        Integer[] eids = new Integer[0];
        try {
            eids = objectMapper.readValue(eidsJsonStr, Integer[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        List<Exam> examList = examMapper.selectByEids(eids);
        for (Exam exam : examList) {
            Integer eid = exam.getEid();
            List<Examinee> examineeList = examineeMapper.selectByEid(eid);
            exam.setExamineeList(examineeList);
            examineeService.getTestPaperListForExam(exam);
        }
        return examList;
    }

    @Override
    public List<Exam> selectByEname(String ename) {
        return examMapper.selectByEname("%" + ename + "%");
    }
}
