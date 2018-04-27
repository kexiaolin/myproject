package com.sub.dbtable.router;

/**
 * @Description: 设置当前线程的变量的工具类，用于设置对应的数据源名称
 */
public class DbContextHolder {
	private static final ThreadLocal<String> DbHolder = new ThreadLocal<String>();
	private static final ThreadLocal<String> tableIndexHolder= new ThreadLocal<String>();
	
	
	public static void setDb(String db){
		DbHolder.set(db);
	}
	
   

	public static String getDb() {
		String db=DbHolder.get();
		return db;
	}

	public static void clearDbIdx() {
		DbHolder.remove();
	}
	
	public static void setTableIdx(String tableIdx){
		tableIndexHolder.set(tableIdx);
	}
	
	public static String getTableIdx(){
		return (String) tableIndexHolder.get();
	}
	public static void clearTableIdx(){
		tableIndexHolder.remove();
	}
	
	
}