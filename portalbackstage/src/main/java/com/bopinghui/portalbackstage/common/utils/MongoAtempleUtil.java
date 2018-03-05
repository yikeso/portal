package com.bopinghui.portalbackstage.common.utils;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;

/**
 * ${DESCRIPTION}
 *
 * @author kakasun
 * @create 2018-03-04 下午9:14
 */
public class MongoAtempleUtil {

    /**
     * 将mongo实体类转update
     * @param o
     * @return
     * @throws IllegalAccessException
     */
    public static Update entity2UpdateIgnoreNull(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        Update update = new Update();
        Object value = null;
        for(Field f:fields){
            f.setAccessible(true);
            value = f.get(o);
            if(value == null){
                continue;
            }
            if(f.getAnnotation(Id.class) != null){
                continue;
            }
            update.set(f.getName(),value);
        }
        return update;
    }
}
