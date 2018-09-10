/**
 *
 */
package com.chenmeikai.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author meikai
 */
public class RequestUtils {

    private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

    /**
     * 将键值对格式的请求参数封装为map集合
     *
     * @param request
     * @return
     */
    public static Map<String, Object> toMap(HttpServletRequest request) {

        if (request == null) {
            log.error("fail to convert to Map ,HttpServletRequest is null !");
            return null;
        }
        Enumeration<String> paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap<String, Object>();
        while ((paramNames != null) && (paramNames.hasMoreElements())) {
            String paramName = (String) paramNames.nextElement();
            String[] values = request.getParameterValues(paramName);
            if ((values != null) && (values.length != 0)) {
                if (values.length > 1)
                    params.put(paramName, values);
                else {
                    params.put(paramName, (values[0] == null) ? null : values[0].trim());
                }
            }
        }
        return params;
    }


    /**
     * 将request流中的数据转换成String,会截流
     *
     * @param request
     * @return
     */
    public static String toString(HttpServletRequest request) {
        String valueStr = "";
        try {
            StringBuffer sb = new StringBuffer();
            InputStream is = request.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String s = "";
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            valueStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            valueStr = "";
        }
        return valueStr;
    }


}
