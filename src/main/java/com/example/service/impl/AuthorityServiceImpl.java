package com.example.service.impl;

import com.example.beans.Authority;
import com.example.mapper.AuthorityMapper;
import com.example.service.AuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

}
