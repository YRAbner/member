package com.item.member.controller;

import com.item.member.Test;
import com.item.member.common.api.CommonPage;
import com.item.member.common.api.CommonResult;
import com.item.member.service.TestService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: yr
 * @desc: 测试
 * @date: 2022/4/13 12:51
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @ApiOperation("分页查询列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Test>> listByPageHelper(@RequestParam(value = "pageNum", defaultValue = "1")
                                @ApiParam("页码") Integer pageNum,
                                                    @RequestParam(value = "pageSize", defaultValue = "3")
                                @ApiParam("每页数量") Integer pageSize){
        List<Test> tests = testService.listByPageHelper(pageNum , pageSize);
        return CommonResult.success(CommonPage.restPage(tests));
    }

    @ApiOperation("添加")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody Test test) {
        CommonResult commonResult;
        int count = testService.create(test);
        if (count == 1) {
            commonResult = CommonResult.success(test);
            LOGGER.debug("createBrand success:{}", test);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", test);
        }
        return commonResult;
    }
}
