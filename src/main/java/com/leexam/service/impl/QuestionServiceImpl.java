package com.leexam.service.impl;

import com.leexam.entity.Question;
import com.leexam.mapper.QuestionMapper;
import com.leexam.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/06
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public List<Question> selectByQids(int[] qids) {
        return questionMapper.selectByQids(qids);
    }

    @Override
    public String insertSelective(Question question) {
        return questionMapper.insertSelective(question) > 0 ? "success" : "error";
    }

    @Override
    public String updateByPrimaryKeySelective(Question question) {
        return questionMapper.updateByPrimaryKeySelective(question) > 0 ? "success" : "error";
    }

    @Override
    public String deleteByPrimaryKey(Integer qid) {
        return questionMapper.deleteByPrimaryKey(qid) > 0 ? "success" : "error";
    }
}
