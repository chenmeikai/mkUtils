/**   
 * Copyright © 2018  
 * @Package: com.chenmeikai.utils.http   
 * @date: 2018年3月14日 上午8:55:32 
 */
package com.chenmeikai.utils.http;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class HttpClientUtils {

	public static String get(String url) {
		CloseableHttpClient httpclient = HttpClientPool.getHttpClient();

		String result = "";
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet(url);

			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				// 响应状态
				int stateCode = response.getStatusLine().getStatusCode();

				if (stateCode == 200) {
					if (entity != null) {
						// 打印响应内容
						result = EntityUtils.toString(entity);
						System.out.println("Response content: " + result);
					}
				}
			} finally {

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void main(String[] args) {
		get("http://www.baidu.com");
	}
}