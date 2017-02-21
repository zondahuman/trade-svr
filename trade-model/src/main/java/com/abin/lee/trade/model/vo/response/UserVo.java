package com.abin.lee.trade.model.vo.response;

import com.abin.lee.trade.common.constant.UserType;
import com.abin.lee.trade.common.constant.ValidStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {

    private static final long serialVersionUID = -4677692001462806073L;

    /** 用户Key */
    private String useKey;

    /** 三方业务编号 */
    private String refId;

    /** 身份证号 */
    private String idNo;

    /** 渠道号 */
    private String channelCode;

    /** 用户类型 */
    private UserType userType;

    /** 用户状态 */
    private ValidStatus status;

    /** 备注 */
    private String remark;





}
