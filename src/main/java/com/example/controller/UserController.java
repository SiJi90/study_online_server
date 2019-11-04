package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.beans.User;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 初始化用户信息表
     */
    @GetMapping("/init")
    public String init() {
        String[] surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王"};
        String[] name = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};

        userService.remove(new QueryWrapper<User>().notIn("user_id", -1));

        List<User> userList = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            userList.add(new User(
                    1,
                    surname[new Random().nextInt(8)] + name[new Random().nextInt(9)],
                    "a" + i,
                    "root",
                    "您秃了吗?",
                    "快了",
                    1
            ));
        }
        userService.saveBatch(userList);
        return "初始化成功";
    }

    /**
     * 根据条件查询用户
     *
     * @param value  关键字
     * @param status 状态
     * @return 查到的用户集合
     */
    public List<User> getUser(String value, int status) {
        // 查询所有审核未通过用户
        return userService.list(
                new QueryWrapper<User>().nested(i -> i.like("user_name", value.trim())
                        .or()
                        .like("user_account", value.trim())
                )
                        .eq("user_status", status)
        );
    }

    /**
     * 按条件查询所有用户
     *
     * @param pageNum  查询页码
     * @param pageSize 查询条数
     * @return 封装好的用户和分页相关信息
     */
    @GetMapping("/list")
    public Msg getUserlist(Integer pageNum, Integer pageSize, String value, String activeName) {
        // 根据页码和每页条数进行查询
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        } else {
            // 返回失败信息
            return Msg.fail();
        }

        List<User> userList = new ArrayList<>();
        // 根据条件模糊查询
        if ("all".equals(activeName)) {
            // 查询所有用户
            userList = userService.list(
                    new QueryWrapper<User>().like("user_name", value.trim())
                            .or()
                            .like("user_account", value.trim())
            );
        } else if ("unreviewed".equals(activeName)) {
            // 查询所有审核未通过用户
            userList = getUser(value, 0);
        } else if ("actived".equals(activeName)) {
            // 查询所有审核未通过用户
            userList = getUser(value, 1);
        } else if ("disabled".equals(activeName)) {
            // 查询所有审核未通过用户
            userList = getUser(value, 2);
        } else {
            // 查询所有审核未通过用户
            userList = getUser(value, 3);
        }

        // 封装好分页和用户相关信息
        PageInfo pageInfo = new PageInfo(userList, 5);
        // 返回前台请求数据
        return Msg.success().add("pageInfo", pageInfo);
    }

    /**
     * 删除用户
     *
     * @param ids 用户id
     * @return 成功 | 失败
     */
    @DeleteMapping("/list")
    public Msg delUser(String ids) {
        // 如果 ids 不为空 & 包含 '-'
        if (!"".equals(ids) && ids.contains("-")) {
            // 批量删除 分割 ids
            String[] list = ids.split("-");
            boolean res = userService.remove(new QueryWrapper<User>().in("user_id", Arrays.asList(list)));
            if (res) {
                return Msg.success();
            }
        } else if (!"".equals(ids)) {
            // 单个删除
            boolean res = userService.remove(new QueryWrapper<User>().eq("user_id", Integer.parseInt(ids)));
            if (res) {
                return Msg.success();
            }
        }
        return Msg.fail();
    }

    /**
     * 新增用户
     *
     * @param newUser 用户实体
     * @return 成功 | 失败
     */
    @PostMapping("/list")
    public Msg addUser(User newUser) {
        // 保存用户到数据库, 构建用户信息
        if (newUser != null) {
            boolean res = userService.save(new User(
                    newUser.getUserRoleId(),
                    newUser.getUserName(),
                    newUser.getUserAccount(),
                    newUser.getUserPass(),
                    "",
                    "",
                    1
            ));
            if (res) {
                return Msg.success();
            }
        }
        return Msg.fail();
    }

}

