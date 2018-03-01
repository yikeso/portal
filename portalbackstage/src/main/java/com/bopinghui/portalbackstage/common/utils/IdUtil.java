package com.bopinghui.portalbackstage.common.utils;

import org.apache.logging.log4j.core.util.UuidUtil;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * id生成工具类
 *
 * @author kakasun
 * @create 2018-03-01 上午8:10
 */
public class IdUtil {

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyMMdd");

    /**
     * 创建一个id
     * @return
     */
    public static String createId(){
        String dateStr = dtf.format(Instant.now());
        return dateStr + com.bopinghui.portalbackstage.common.utils.UuidUtil.randomUuid();
    }
}