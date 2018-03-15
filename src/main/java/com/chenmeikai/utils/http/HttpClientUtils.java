/**   
 * Copyright © 2018  
 * @Package: com.chenmeikai.utils.http   
 * @date: 2018年3月14日 上午8:55:32 
 */
package com.chenmeikai.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

public class HttpClientUtils {

	private final static Logger log = LoggerFactory.getLogger(HttpClientUtils.class);

	@SuppressWarnings("unchecked")
	public static String doGet(String urlString, Map<String, String>... headers) {
		String result = "";
		// 获取httpclient连接
		CloseableHttpClient httpclient = HttpClientPool.getHttpClient();
		// 定义请求设置 ConnectTimeout连接超时，SocketTimeout读取数据超时
		RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(5000).build();
		// 执行get请求.
		CloseableHttpResponse response;
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

		// 超时设置
		httpGet.setConfig(requestConfig);
		
		//默认请求头
		setCommonHeaders(httpGet);

		//请求头修改
		if (headers != null && headers.length > 0) {
			for (Map.Entry<String, String> header : headers[0].entrySet()) {
				if (httpGet.containsHeader(header.getKey())) {
					httpGet.setHeader(header.getKey(), header.getValue());
				} else {
					httpGet.addHeader(header.getKey(), header.getValue());
				}
			}
		}
		response = httpclient.execute(httpGet);
		// 响应状态码
		int stateCode = response.getStatusLine().getStatusCode();
		if (stateCode == 200) {
			// 获取响应实体
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// 打印响应内容
				result = EntityUtils.toString(entity);
				return result;
			}
		}else {
			log.warn(urlString+"-请求返回的状态码"+stateCode);
			result="{'code':"+stateCode+"}";
			return  result;
		}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}catch (URISyntaxException e) {
			e.printStackTrace();
		}finally {
			httpGet.abort();
		}
        return  result;
	}

	private static void setCommonHeaders(AbstractHttpMessage request) {
		request.addHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		// request.addHeader("Connection", "keep-alive");
		request.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
		request.addHeader("Accept-Encoding", "gzip, deflate, br");
		// User-Agent最好随机换
		request.addHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36");
	}

}