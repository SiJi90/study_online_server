package com.example.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.beans.Course;
import com.example.beans.Courseware;
import com.example.service.CourseService;
import com.example.service.CoursewareService;
import com.example.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    CoursewareService coursewareService;

    /**
     * 返回所有课程
     *
     * @return 课程集合列表
     */
    @GetMapping("list")
    public Msg list() {
        List<Course> list = courseService.list();
        return Msg.success().add("list", list);
    }

    /**
     * 根据 id 删除课程
     *
     * @param id 课程id
     * @return 成功 | 失败
     */
    @DeleteMapping
    public Msg delOne(Integer id) {
        boolean res = courseService.removeById(id);
        if (res) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

    /**
     * 获取某个课程的所有课件信息
     *
     * @param courseId 课程id
     * @return 课件信息
     */
    @GetMapping("courseware")
    public Msg getCourseWareList(Integer courseId) {
        List<Courseware> coursewareList = coursewareService.list(new QueryWrapper<Courseware>()
                .eq("cw_course_id", courseId));
        return Msg.success().add("list", coursewareList);
    }
}

