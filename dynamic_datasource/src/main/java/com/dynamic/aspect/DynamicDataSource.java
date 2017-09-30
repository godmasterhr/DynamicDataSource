package com.dynamic.aspect;

import com.dynamic.util.DBContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by Administrator on 2017/9/30.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 返回多个数据源中的给定的某一个数据源(程序控制给定)
     * @return
     */
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.getDBType();
    }
}
