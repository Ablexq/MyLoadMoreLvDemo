package com.example.xuqiang.myloadmorelvdemo.demo2.util;

import java.util.List;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class ListUtils {

    public static boolean isEmpty(List list) {
        if (list == null || list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isNotEmpty(List list) {
        if (list == null || list.size() == 0) {
            return false;
        } else {
            return true;
        }
    }

}