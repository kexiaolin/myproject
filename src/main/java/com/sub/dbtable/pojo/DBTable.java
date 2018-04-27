package com.sub.dbtable.pojo;

import java.io.Serializable;

import com.sub.dbtable.router.DbContextHolder;


/**
 * @Description 分库分表的pojo继承此类
 */
public class DBTable  {

    private String tableIdx;//分表的后缀_0000

	public String getTableIdx() {
		this.tableIdx=DbContextHolder.getTableIdx();
		return tableIdx;
	}

	public void setTableIdx(String tableIdx) {
		this.tableIdx = tableIdx;
	}
    


}
