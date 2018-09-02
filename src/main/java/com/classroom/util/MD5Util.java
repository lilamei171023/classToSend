package com.classroom.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * md5加密算法工具类
 * Created by liuyanlong on 2017/8/6.
 */
public class MD5Util {
    /**
     * 生成含有随机盐的密码
     *
     * @param password 密码
     * @param salt     盐值
     * @return 加密后的字符串
     */
    public static String generate(String password, String salt) {

        StringBuffer sb=new StringBuffer();
        sb.append(salt);
        if (salt.length() < 16) {
            for (int i=0; i < 16 - salt.length(); ++i) {
                sb.append(i);
            }
        }
        salt=sb.toString();
        password=md5Hex(password + salt);

        //对password进行乱序
        char[] cs=new char[48];
        for (int i=0; i < 48; i+=3) {
            cs[i]=password.charAt(i / 3 * 2);
            char c=salt.charAt(i / 3);
            cs[i + 1]=c;
            cs[i + 2]=password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     *
     * @param src 源字符串
     * @return 目标字符串
     */
    public static String md5Hex(String src) {
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            byte[] bs=md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }
}
