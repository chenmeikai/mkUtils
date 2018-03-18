/**   
 * Copyright © 2018 
 * @Package: Http.java 
 * @author: Administrator   
 * @date: 2018年3月17日 上午10:42:45 
 */
package com.meikai.utils;

import java.util.HashMap;
import java.util.Map;

import com.chenmeikai.utils.http.HttpClientUtils;

/**
 * @Description:TODO
 * @author: cmk
 * @date: 2018年3月17日 上午10:42:45
 */
public class Http {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String result = "";
		// String url ="http://api.zb.com/data/v1/ticker?market=btc_usdt";
//		String url = "http://127.0.0.1:7070/active";
		String url = "http://127.0.0.1:7070/postTest";
//		String url ="http://api.zb.com/data/v1/ticker";
		Map<String, String> params = new HashMap<>();
		Map<String, String> headers = new HashMap<>();
		params.put("user", "btc_usdt");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
//		headers.put("Content-Type", "application/json");
		System.out.println(HttpClientUtils.doPost(url, params,headers));

	}

}
