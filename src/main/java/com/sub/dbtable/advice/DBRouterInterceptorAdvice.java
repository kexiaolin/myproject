package com.sub.dbtable.advice;

import java.lang.reflect.Method;
/**
 * @description拦截器，在操作数据库之前，进行路由，根据一定路由规则，操作合适的库和表
 * @author kexiaolin
 */


import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.sub.dbtable.router.RouterConstants;
import com.sub.dbtable.strategy.DBRouterStrategy;
@Service("dataSourceAdvice")
public class DBRouterInterceptorAdvice implements MethodBeforeAdvice{
    @Autowired
	private DBRouterStrategy dbRouterStrategy;
	
	//按照什么字段进行分库路由,在配置文件中指定
	@Value("${db.route.field}")
	
	private String routeField;

	@Override
	public void before(Method method, Object[] params, Object target) throws Throwable {

		if (StringUtils.isBlank(routeField)) {
			routeField=RouterConstants.DEFAULT_ROUTER_FIELD;
		}

		String routeFieldValue = BeanUtils.getProperty(params[0], routeField);
		if (StringUtils.isNotBlank(routeFieldValue)) {

			dbRouterStrategy.doRouteStrategy(routeFieldValue);

		}
	}

	public DBRouterStrategy getDbRouterStrategy() {
		return dbRouterStrategy;
	}

	public void setDbRouterStrategy(DBRouterStrategy dbRouterStrategy) {
		this.dbRouterStrategy = dbRouterStrategy;
	}

	public String getRouteField() {
		return routeField;
	}

	public void setRouteField(String routeField) {
		this.routeField = routeField;
	}
	

}
