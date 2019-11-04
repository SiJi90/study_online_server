package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 课程表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Course implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 课程id （自增长）
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程名
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 课程代码
     */
    @TableField("course_code")
    private String courseCode;

    /**
     * 课程学分
     */
    @TableField("course_credit")
    private Integer courseCredit;

    /**
     * 课程状态（0 ：关闭， 1： 开启）
     */
    @TableField("course_status")
    private Integer courseStatus;


}
