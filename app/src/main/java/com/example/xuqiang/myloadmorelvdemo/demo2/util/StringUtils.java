package com.example.xuqiang.myloadmorelvdemo.demo2.util;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase());
    }

    public static boolean isNotEmpty(String s) {
        if (s == null || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase())) {
            return false;
        }
        return true;
    }
}
