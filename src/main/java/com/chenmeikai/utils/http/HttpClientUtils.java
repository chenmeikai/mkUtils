/**   
 * Copyright © 2018  
 * @Package: com.chenmeikai.utils.http   
 * @date: 2018年3月14日 上午8:55:32 
 */
package com.chenmeikai.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HttpClientUtils {

	private final static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	public static String doGet(String urlString, Map<String, String> headers) {

		// 获取httpclient连接
		CloseableHttpClient httpclient = HttpClientPool.getHttpClient();

		// 定义请求设置 ConnectTimeout连接超时，SocketTimeout读取数据超时
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(5000).build();

		// 执行get请求.
		CloseableHttpResponse response;

		String result = "";
		
		HttpGet httpGet = null;  
        urlString = urlString.trim();  
        if (null == urlString || urlString.isEmpty() || !urlString.startsWith("http")) {  
            return result;  
        }  
        // 转化String url为URI,解决url中包含特殊字符的情况  
        try {  
            URL url = new URL(urlString);  
            URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), null);  
            httpGet = new HttpGet(uri);  
            setCommonHeaders(httpGet);  

		// 超时设置
		httpGet.setConfig(requestConfig);
		
		
		
		
		

		// 请求头设置
		if (headers != null && headers.size() > 0) {
			for (Map.Entry<String, String> header : headers.entrySet()) {
				if (httpGet.containsHeader(header.getKey())) {
					httpGet.setHeader(header.getKey(), header.getValue());
				} else {
					httpGet.addHeader(header.getKey(), header.getValue());
				}
			}
		}
		try {
			response = httpclient.execute(httpGet);
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			// 响应状态
			int stateCode = response.getStatusLine().getStatusCode();

			if (stateCode == 200) {
				if (entity != null) {
					// 打印响应内容
					result = EntityUtils.toString(entity);
					log.info("Response content: " + result);
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}