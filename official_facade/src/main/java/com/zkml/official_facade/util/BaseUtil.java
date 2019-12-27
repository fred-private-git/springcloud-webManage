package com.zkml.official_facade.util;

import org.dozer.DozerBeanMapper;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/**
 * 一些常用工具类
 * @author : qin dong on 2019/4/11 9:39
 */
public class BaseUtil {

    /**
     * 获取uuid
     * @return
     */
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("\\-", "");
    }

    /**
     * 对象之间转换 Obj A --> Obj B
     * @param source            源Obj
     * @param destinationClass  目标Obj
     * @param <T>               泛型
     * @return  目标对象Obj
     */
    public static <T> T map(Object source, Class<T> destinationClass) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        if (source == null) {
            return null;
        }
        return mapper.map(source, destinationClass);
    }

    /**
     * 对象list之间转换 List A --> List B
     * @param sourceList          源List
     * @param destinationClass    目标List
     * @param <T>                 泛型
     * @return 目标List
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static <T> List<T> mapList(Collection sourceList, Class<T> destinationClass) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<T> destinationList = new ArrayList();
        if (sourceList == null) {
            return destinationList;
        }
        for (Object sourceObject : sourceList) {
            if (sourceObject != null) {
                T destinationObject = mapper.map(sourceObject, destinationClass);
                destinationList.add(destinationObject);
            }
        }
        return destinationList;
    }

    /**
     * md5加密
     * @param paramArrayOfByte
     * @return
     */
    public static String getMD5(byte[] paramArrayOfByte)
    {
        String str = null;
        char[] arrayOfChar1 = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
        try
        {
            MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
            localMessageDigest.update(paramArrayOfByte);
            byte[] arrayOfByte = localMessageDigest.digest();
            char[] arrayOfChar2 = new char[32];
            int i = 0;
            for (int j = 0; j < 16; j++)
            {
                int k = arrayOfByte[j];
                arrayOfChar2[(i++)] = arrayOfChar1[(k >>> 4 & 0xF)];
                arrayOfChar2[(i++)] = arrayOfChar1[(k & 0xF)];
            }
            str = new String(arrayOfChar2);
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return str;
    }
}
