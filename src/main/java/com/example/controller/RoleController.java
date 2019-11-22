package com.example.controller;


import com.example.beans.Role;
import com.example.service.RoleService;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 获取所有角色列表
     *
     * @return 向前端返回所有角色
     */
    @GetMapping("/list")
    public Msg list() {
        List<Role> list = roleService.list();
        return Msg.success().add("roleList", list);
    }

    /**
     * 删除单个角色
     * @param id 角色 id
     * @return 成功 | 失败
     */
    @DeleteMapping
    public Msg delOne(Integer id) {
        boolean res = roleService.removeById(id);
        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    @PostMapping
    public Msg addOne(String roleName) {
        boolean res = roleService.save(new Role(roleName));
        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }
}

