package com.item.member.service;

import com.item.member.Test;

import java.util.List;

/**
 * @author: yr
 * @desc: 测试Service
 * @date: 2022/4/13 13:06
 */
public interface TestService {
    List<Test> listByPageHelper(int pageNum , int pageSize);

    int create(Test test);
}
