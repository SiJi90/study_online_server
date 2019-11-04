package com.example.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 学员批次表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class StuBatch implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 学员批次表自增主键
     */
    @TableId(value = "batch_id", type = IdType.AUTO)
    private Integer batchId;

    /**
     * 批次名称
     */
    @TableField("batch_name")
    private String batchName;

    /**
     * 批次开始时间
     */
    @TableField("batch_start_time")
    private LocalDateTime batchStartTime;

    /**
     * 批次结束时间
     */
    @TableField("batch_end_time")
    private LocalDateTime batchEndTime;

    /**
     * 资格学分（达到这个学分才能拿到资格证书）
     */
    @TableField("batch_credit")
    private Integer batchCredit;


}
