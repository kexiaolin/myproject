package com.sub.dbtable.strategy;



import com.sub.dbtable.router.DbContextHolder;
import com.sub.dbtable.router.RouterConstants;
import com.sub.dbtable.router.RouterDBTableConfig;
import com.sub.dbtable.util.RouterUtils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @Description 根据指定变量 动态切换库和表
 * 
 */
@Service
public class DBRouterStrategyImpl implements DBRouterStrategy {

	@Autowired
	private RouterDBTableConfig dbTableRouterConfig;

	@Override
	public String doRouteStrategy(String tableFieldValue) {

		int routeFieldInt = RouterUtils.getHashCode(tableFieldValue);
		String db = null;
		if (dbTableRouterConfig.getDbs() != null && dbTableRouterConfig.getDbNum() != 0) {
			long dbIndex = 0;
			long tbIndex = 0;
			// 默认按照分库进行计算
			long mode = dbTableRouterConfig.getDbNum();
			
			if (dbTableRouterConfig.getRouteType() == RouterDBTableConfig.ROUTER_TYPE_DBANDTABLE
					&& dbTableRouterConfig.getTableNum() != 0) {//分库分表
				/**
				 * 分库分表的策略相对于后边两种复杂一些，一种常见的路由策略如下： １、中间变量 ＝ field%（库数量*每个库的表数量）;
				 * ２、库序号 ＝ 取整（中间变量／每个库的表数量）; ３、表序号 ＝ 中间变量％每个库的表数量;
				 **/
				mode = dbTableRouterConfig.getDbNum() * dbTableRouterConfig.getTableNum();
				dbIndex = routeFieldInt % mode / dbTableRouterConfig.getTableNum();
				tbIndex = routeFieldInt % dbTableRouterConfig.getTableNum();
				String tableIndex = formatTableIdx(tbIndex);
				DbContextHolder.setTableIdx(tableIndex);
			} else if (dbTableRouterConfig.getRouteType() == RouterDBTableConfig.ROUTER_TYPE_DB) {// 分库
				mode = dbTableRouterConfig.getDbNum();
				dbIndex = routeFieldInt % mode;
			} else if (dbTableRouterConfig.getRouteType() == RouterDBTableConfig.ROUTER_TYPE_TABLE) {// 分表
				tbIndex = routeFieldInt % dbTableRouterConfig.getTableNum();
				String tableIndex = formatTableIdx(tbIndex);
				DbContextHolder.setTableIdx(tableIndex);
			}
			db = dbTableRouterConfig.getDbs().get((int)dbIndex);
			DbContextHolder.setDb(db);
		}
		return db;

	}


	private static String formatTableIdx( long tbIndex) {
		String tableIndex = null;
		DecimalFormat df = new DecimalFormat();
		df.applyPattern(RouterConstants.DEFAULT_ROUTER_TABLE_SUFFIX);//_0001
		tableIndex = df.format(tbIndex);
		return tableIndex;
	}

}
