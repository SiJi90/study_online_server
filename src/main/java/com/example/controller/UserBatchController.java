package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.beans.StuBatch;
import com.example.beans.UserBatch;
import com.example.service.StuBatchService;
import com.example.service.UserBatchService;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 用户-批次关系表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/userBatch")
public class UserBatchController {

    @Autowired
    private UserBatchService userBatchService;

    @Autowired
    private StuBatchService stuBatchService;

    /**
     * 添加 学生-批次 关系
     *
     * @param batchId 批次 id
     * @param ids     学生 id 集合
     * @return 成功 | 失败
     */
    @PostMapping
    public Msg save(Integer batchId, String ids) {
        List<Integer> idList = new ArrayList<>();
        boolean res = false;
        if (ids.contains("-")) {
            String[] allId = ids.split("-");
            for (String s : allId) {
                idList.add(Integer.parseInt(s));
            }
            Collection<UserBatch> userBatches = new ArrayList<>();
            for (Integer id : idList) {
                UserBatch record = userBatchService.getOne(new QueryWrapper<UserBatch>().eq("user_id", id));
                if (record == null || !record.getBatchId().equals(batchId)) {
                    userBatches.add(new UserBatch(id, batchId));
                }
            }
            res = userBatchService.saveBatch(userBatches);


        } else {
            UserBatch record = userBatchService.getOne(new QueryWrapper<UserBatch>().eq("user_id",
                    Integer.parseInt(ids)));
            if (record == null || record.getBatchId().equals(batchId)) {
                res = userBatchService.save(new UserBatch(Integer.parseInt(ids), batchId));
            }
        }

        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 查询某个所有记录
     *
     * @param batchId 批次id
     * @return 所有关于批次信息
     */
    @GetMapping
    public Msg getStudentList(Integer batchId) {
        List<UserBatch> batchList = userBatchService.list(new QueryWrapper<UserBatch>().eq("batch_id", batchId));
        return Msg.success().add("batchList", batchList);
    }

    /**
     * 查询该用户所有批次
     * @param userId
     * @return
     */
    @GetMapping("list")
    public Msg getBatchList(Integer userId) {
        List<UserBatch> userBatches = userBatchService.list(new QueryWrapper<UserBatch>().eq("user_id", userId));
        if (userBatches != null) {
            List<Integer> batchIds = new ArrayList<>();
            for (UserBatch userBatch : userBatches) {
                batchIds.add(userBatch.getBatchId());
            }
            List<StuBatch> batchs = stuBatchService.list(new QueryWrapper<StuBatch>().in("batch_id", batchIds));
            return Msg.success().add("batchList", batchs);
        }
        return Msg.fail();
    }

}

