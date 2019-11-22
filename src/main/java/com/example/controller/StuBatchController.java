package com.example.controller;


import com.example.beans.StuBatch;
import com.example.service.StuBatchService;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 学员批次表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/stuBatch")
public class StuBatchController {

    @Autowired
    private StuBatchService stuBatchService;

    /**
     * 获取批次列表
     *
     * @return batchList
     */
    @GetMapping
    public Msg getBatchList() {
        List<StuBatch> batchList = stuBatchService.list();
        return Msg.success().add("batchList", batchList);
    }

    /**
     * 单个删除批次
     *
     * @param id 批次id
     * @return 成功 | 失败 信息
     */
    @DeleteMapping
    public Msg delOne(Integer id) {
        boolean res = stuBatchService.removeById(id);
        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}

