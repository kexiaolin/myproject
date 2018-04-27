package com.sub.dbtable.strategy;

public interface DBRouterStrategy {
    /**根据数据库字段的值进行路由*/
	//返回数据库的分库后缀
    public String doRouteStrategy(String tableFieldValue);

}
