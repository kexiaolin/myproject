package com.sub.dbtable.router;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.sub.dbtable.router.DbContextHolder;

import java.util.logging.Logger;

/**
 *Spring动态数据库的实现
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
    	return DbContextHolder.getDb();//获取当前数据源
    }

}