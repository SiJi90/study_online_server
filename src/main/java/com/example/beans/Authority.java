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
 * 权限表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Authority implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 权限id(自增长主键）
     */
    @TableId(value = "auth_id", type = IdType.AUTO)
    private Integer authId;

    /**
     * 权限名称
     */
    @TableField("auth_name")
    private String authName;

    /**
     * 权限说明
     */
    @TableField("auth_info")
    private String authInfo;


}
