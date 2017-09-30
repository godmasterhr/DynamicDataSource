package com.dynamic.util;

/**
 * Created by Administrator on 2017/9/30.
 * 自动/手动 切换数据源
 */
public class DBContextHolder {

    /**
     * 定义两个数据源标识
     */

    private static final String DATA_SOURCE_BASE = "base";
    private static final String DATA_SOURCE_SLAVE = "slave";

    /**
     * 创建本地线程 存放数据源标识  防止高并发线程安全问题
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();


    /**
     * 设置数据源
     */
    public static void setDBType(String dbType){
        contextHolder.set(dbType);
    }

    /**
     * 获得数据源
     */
    public static String getDBType(){
        return contextHolder.get();
    }

    /**
     * 移除数据源
     */
    public static void clearDBType(){
        contextHolder.remove();
    }
}
