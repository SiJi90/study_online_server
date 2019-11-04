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
 * 用户-批次关系表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserBatch implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增长主键
     */
    @TableId(value = "ub_id", type = IdType.AUTO)
    private Integer ubId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 学员批次id
     */
    @TableField("batch_id")
    private Integer batchId;


}
