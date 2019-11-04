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
 * 用户表
 * </p>
 *
 * @author siji
 * @since 2019-10-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id（自增长主键）
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 角色id
     */
    @TableField("user_role_id")
    private Integer userRoleId;

    /**
     * 用户姓名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户登录账号
     */
    @TableField("user_account")
    private String userAccount;

    /**
     * 用户登录账号
     */
    @TableField("user_pass")
    private String userPass;

    /**
     * 找回密码问题
     */
    @TableField("user_find_question")
    private String userFindQuestion;

    /**
     * 找回密码答案
     */
    @TableField("user_find_answer")
    private String userFindAnswer;

    /**
     * 用户状态（0：待审核， 1：激活， 2： 禁用， 3：审核未通过
     */
    @TableField("user_status")
    private Integer userStatus;

    public User() {

    }

    /**
     * 重载构造器, 除了自增id
     *
     * @param userRoleId
     * @param userName
     * @param userAccount
     * @param userPass
     * @param userFindQuestion
     * @param userFindAnswer
     * @param userStatus
     */
    public User(Integer userRoleId, String userName, String userAccount, String userPass, String userFindQuestion, String userFindAnswer, Integer userStatus) {
        this.userRoleId = userRoleId;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.userFindQuestion = userFindQuestion;
        this.userFindAnswer = userFindAnswer;
        this.userStatus = userStatus;
    }
}
