package com.bopinghui.portalbackstage.common.utils;

import java.util.UUID;

/**
 * uuid工具
 *
 * @author kakasun
 * @create 2018-03-01 上午8:16
 */
public class UuidUtil {

    /**
     * 随机一个uuid
     * @return
     */
    public static String randomUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-","");
    }
}
