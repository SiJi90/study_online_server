package com.example.service.impl;

import com.example.beans.Course;
import com.example.mapper.CourseMapper;
import com.example.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
