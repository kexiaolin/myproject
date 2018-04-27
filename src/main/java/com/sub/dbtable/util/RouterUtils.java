package com.sub.dbtable.util;


import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;


public class RouterUtils {

	/**
	 * 获取哈希值
	 * @param routeValue
	 * @return
	 */
	public static int getHashCode(String routeValue) {

		int code=0;
		try {
			int hashCode = 0;
			String pinBase64 = Base64.encodeBase64String(routeValue.getBytes("utf-8"));
			hashCode = Math.abs(pinBase64.hashCode());
			code = hashCode % 10000;
			return code;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
