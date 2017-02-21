package com.abin.lee.trade.model;

import com.abin.lee.trade.common.constant.UserType;
import com.abin.lee.trade.common.constant.ValidStatus;
import com.abin.lee.trade.model.base.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 用户
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class User extends BaseModel {

    private static final long serialVersionUID = -2051319865468611797L;

    /** 用户Key */
    @Column(name = "user_key", nullable = false, unique = true)
    private String userKey;

    /** 三方业务编号 */
    @Column(name = "ref_id", nullable = false)
    private String refId;

    /** 身份证号 */
    @Column(name = "id_no")
    private String idNo;

    /** 渠道编号 */
    @Column(name = "channel_code", nullable = false)
    private String channelCode;

    /** 用户类型 */
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", nullable = false)
    private UserType userType;

    /** 用户状态 */
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ValidStatus status;

    /** 备注 */
    @Column(name = "remark")
    private String remark;

}
