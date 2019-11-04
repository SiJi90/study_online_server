package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学员学习记录表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StuRecord implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 记录id（自增长主键）
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

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

    /**
     * 课件状态（0：未完成， 1：已完成）
     */
    @TableField("record_status")
    private Integer recordStatus;


}
