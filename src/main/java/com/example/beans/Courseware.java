package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 课件表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Courseware implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "cw_id", type = IdType.AUTO)
    private Integer cwId;

    /**
     * 所属课程id
     */
    @TableField("cw_course_id")
    private Integer cwCourseId;

    /**
     * 课件名称
     */
    @TableField("cw_name")
    private String cwName;

    /**
     * 课件地址（资源路径）
     */
    @TableField("cw_addr")
    private String cwAddr;

    /**
     * 课件封面地址（图片路径）
     */
    @TableField("cw_img_addr")
    private String cwImgAddr;

    /**
     * 课件简介
     */
    @TableField("cw_info")
    private String cwInfo;

    /**
     * 课件类型（0：视频，1：ppt）
     */
    @TableField("cw_type")
    private Integer cwType;

    /**
     * 课件上传时间
     */
    @TableField("cw_time")
    private LocalDateTime cwTime;

}
