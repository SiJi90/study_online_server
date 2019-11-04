package com.example.controller;


import com.example.beans.Role;
import com.example.service.impl.RoleServiceImpl;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/list")
    public Msg getRoleList() {
        List<Role> roleList = roleService.list();
        return Msg.success().add("roleList", roleList);
    }

}

