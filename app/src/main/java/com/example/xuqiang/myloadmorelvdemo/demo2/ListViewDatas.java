package com.example.xuqiang.myloadmorelvdemo.demo2;

import java.util.ArrayList;

/**
 * ================================================
 * 作    者：marsxq
 * 创建日期：2018/4/8
 * 描    述：
 * ================================================
 */
public class ListViewDatas {
    //模拟服务器端数据库中的数据，假设现在只有3条数据
    public static int NUM=53;
    public static ArrayList<String> returnNum(int startNum, int endNum){
        ArrayList<String> list=new ArrayList<String>();
        if(endNum<=NUM){//客户端请求的数据在数据库数据范围之内
            for(int i=startNum;i<=endNum;i++){
                list.add(String.valueOf(i));
            }
            return list;
        }else if(endNum>=NUM&&startNum<=NUM){//客户端请求的数据不全在数据库数据范围之内
            for(int i=startNum;i<=NUM;i++){
                list.add(String.valueOf(i));
            }
            return list;
        }else if(startNum>NUM){//客户端请求的数据超出数据库数据范围之内
            return null;
        }
        return null;
    }
}