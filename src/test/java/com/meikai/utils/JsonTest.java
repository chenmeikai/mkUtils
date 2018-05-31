/**   
 * Copyright © 2018  
 * @Package: com.meikai.utils   
 * @date: 2018年5月31日 上午9:06:18 
 */
package com.meikai.utils;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.chenmeikai.utils.json.JsonUtils;

/**    
 * @Description:fastJson方法测试 
 * @author: cmk
 * @date:   2018年5月31日 上午9:06:18      
 */
public class JsonTest {
	
	
	@Test
	public void test() {
		String jsonText ="{     \"name\": \"BeJson\",     \"url\": \"http://www.bejson.com\",     \"page\": 88,     \"isNonProfit\": true,     \"address\": {         \"street\": \"科技园路.\",         \"city\": \"江苏苏州\",         \"country\": \"中国\"     },     \"links\": [         {             \"name\": \"Google\",             \"url\": \"http://www.google.com\"         },         {             \"name\": \"Baidu\",             \"url\": \"http://www.baidu.com\"         },         {             \"name\": \"SoSo\",             \"url\": \"http://www.SoSo.com\"         }     ] }";
		JSONObject object=    (JSONObject) JsonUtils.toObject(jsonText);
		String name =object.getString("names");
		System.out.println(name);
	}
	
	@Test
	public void test2() {
		
	}

}

class User {
	
	private Long id;
	
	private String name;
	
	private int age ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
