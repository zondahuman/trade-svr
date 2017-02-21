package com.abin.lee.trade.common.util;

import java.util.UUID;

public class UniqueKeyUtils {

    public static String uniqueKey() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

}
