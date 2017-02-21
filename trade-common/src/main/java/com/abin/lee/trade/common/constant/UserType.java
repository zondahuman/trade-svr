package com.abin.lee.trade.common.constant;

/**
 * Created by zhoujiuping on 2016/12/7.
 */
public enum UserType {

    SYSTEM {
        @Override
        public String toString() {
            return "系统用户";
        }
    },
    COMMON {
        @Override
        public String toString() {
            return "普通用户";
        }
    };

    @Override
    public abstract String toString();

}
