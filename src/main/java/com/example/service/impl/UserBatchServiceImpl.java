package com.example.service.impl;

import com.example.beans.UserBatch;
import com.example.mapper.UserBatchMapper;
import com.example.service.UserBatchService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-批次关系表 服务实现类
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Service
public class UserBatchServiceImpl extends ServiceImpl<UserBatchMapper, UserBatch> implements UserBatchService {

}
