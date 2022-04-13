package com.item.member.service.impl;

import com.github.pagehelper.PageHelper;
import com.item.member.Test;
import com.item.member.TestExample;
import com.item.member.mapper.TestMapper;
import com.item.member.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yr
 * @desc: test实现类
 * @date: 2022/4/13 13:10
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> listByPageHelper(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum , pageSize);

        return testMapper.selectByExample(new TestExample());
    }

    @Override
    public int create(Test test) {

        return testMapper.insertSelective(test);
    }
}
