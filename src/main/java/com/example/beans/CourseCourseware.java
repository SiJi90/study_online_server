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
 * 课程-课件关系表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CourseCourseware implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增长id
     */
    @TableId(value = "cc_id", type = IdType.AUTO)
    private Integer ccId;

    /**
     * 课程id
     */
    @TableField("course_id")
    private Integer courseId;

    /**
     * 课件id
     */
    @TableField("cw_id")
    private Integer cwId;


}
