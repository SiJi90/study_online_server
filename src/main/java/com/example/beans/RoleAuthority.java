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
 * 角色权限关系表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class RoleAuthority implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 自增长id
     */
    @TableId(value = "ra_id", type = IdType.AUTO)
    private Integer raId;

    /**
     * 角色表id
     */
    @TableField("role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @TableField("auth_id")
    private Integer authId;


}
