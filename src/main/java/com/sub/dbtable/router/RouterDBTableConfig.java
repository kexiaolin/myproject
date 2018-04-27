package com.sub.dbtable.router;

import java.util.List;

/**
 * 分库分表配置 ，包括数据库数量，每个数据库表数量等
 */
public class RouterDBTableConfig {


    /*路由类型*/
    public final static int ROUTER_TYPE_DB=0;//只分库
    public final static int ROUTER_TYPE_TABLE =1;//只分表
    public final static int ROUTER_TYPE_DBANDTABLE=2;//既分库又分表
	
    /*数据库列表*/
    private List<String> dbs;
    /*数据库数量*/
    private int dbNum;
    /*每个数据库的表数量*/
    private int tableNum;
    /*路由类型*/
    private int routeType;


  

    public List<String> getDbs() {
		return dbs;
	}

	public void setDbs(List<String> dbs) {
		this.dbs = dbs;
	}

	public int getDbNum() {
		return dbNum;
	}

	public void setDbNum(int dbNum) {
		this.dbNum = dbNum;
	}

	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

    public int getRouteType() {
        return routeType;
    }

    public void setRouteType(int routeType) {
        this.routeType = routeType;
    }
}
