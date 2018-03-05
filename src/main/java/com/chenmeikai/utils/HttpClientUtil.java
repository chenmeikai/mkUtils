package com.chenmeikai.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtil {
	
	private static final Logger log =LoggerFactory.getLogger(HttpClientUtil.class);
    
	
	/**
	 * post请求，json格式参数，连接超时默认10秒，读取超时默认10秒
	 * @param path 请求地址
	 * @param postContent 请求参数
	 * @return
	 */
	public static String sendJsonPost(String path, String postContent) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(10000);//连接超时 单位毫秒
			httpURLConnection.setReadTimeout(10000);//读取超时 单位毫秒
			httpURLConnection.setDoOutput(true);//允许写出
			httpURLConnection.setDoInput(true);//允许读入
			httpURLConnection.setUseCaches(false);//不使用缓存
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/json");
			httpURLConnection.connect();
			OutputStream os=httpURLConnection.getOutputStream();
			os.write(postContent.getBytes("UTF-8"));
			os.flush();
			
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();

			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	
	/**
	 * post请求，json格式参数
	 * @param path 请求地址
	 * @param postContent 请求参数
	 * @param connectTime 连接超时(毫秒)
	 * @param readTime 读取超时(毫秒)
	 * @return
	 */
	public static String sendJsonPost(String path, String postContent,int connectTime,int readTime) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(connectTime);//连接超时 单位毫秒.
			httpURLConnection.setReadTimeout(readTime);//读取超时 单位毫秒
			httpURLConnection.setDoOutput(true);//允许写出
			httpURLConnection.setDoInput(true);//允许读入
			httpURLConnection.setUseCaches(false);//不使用缓存
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/json");

			httpURLConnection.connect();
			OutputStream os=httpURLConnection.getOutputStream();
			os.write(postContent.getBytes("UTF-8"));
			os.flush();
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	

	/**
	 * post请求，键值对参数
	 * @param path 请求地址
	 * @param postContent 请求参数
	 * @param connectTime 连接超时(毫秒)
	 * @param readTime 读取超时(毫秒)
	 * @return
	 */
	public static String sendKeyValuePost(String path, String postContent,int connectTime,int readTime) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(connectTime);//连接超时 单位毫秒.
			httpURLConnection.setReadTimeout(readTime);//读取超时 单位毫秒
			httpURLConnection.setDoOutput(true);//允许写出
			httpURLConnection.setDoInput(true);//允许读入
			httpURLConnection.setUseCaches(false);//不使用缓存
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.connect();
			OutputStream os=httpURLConnection.getOutputStream();
			os.write(postContent.getBytes("UTF-8"));
			os.flush();
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	
	
	/**
	 * post请求，键值对参数
	 * @param path 请求地址
	 * @param params 请求参数
	 * @param connectTime 连接超时(毫秒)
	 * @param readTime 读取超时(毫秒)
	 * @return
	 */
	public static String sendKeyValuePost(String path, Map<String,String> params,int connectTime,int readTime) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("POST");// 提交模式
			httpURLConnection.setConnectTimeout(connectTime);//连接超时 单位毫秒.
			httpURLConnection.setReadTimeout(readTime);//读取超时 单位毫秒
			httpURLConnection.setDoOutput(true);//允许写出
			httpURLConnection.setDoInput(true);//允许读入
			httpURLConnection.setUseCaches(false);//不使用缓存
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.connect();
			OutputStream os=httpURLConnection.getOutputStream();
			String postContent =mapToString(params);
			os.write(postContent.getBytes("UTF-8"));
			os.flush();
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	
	
	/**
	 * get请求，键值对参数
	 * @param path 请求地址+参数(如果有)
	 * @param params 请求参数
	 * @param connectTime 连接超时(毫秒)
	 * @param readTime 读取超时(毫秒)
	 * @return
	 */
	public static String sendGet(String path,int connectTime,int readTime) {
		URL url = null;
		try {
			url = new URL(path);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");// 提交模式
			httpURLConnection.setConnectTimeout(connectTime);//连接超时 单位毫秒.
			httpURLConnection.setReadTimeout(readTime);//读取超时 单位毫秒
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.connect();
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	
	/**
	 * get请求，键值对参数
	 * @param path 请求地址
	 * @param params 请求参数
	 * @param connectTime 连接超时(毫秒)
	 * @param readTime 读取超时(毫秒)
	 * @return
	 */
	public static String sendGet(String path, Map<String,String> params,int connectTime,int readTime) {
		URL url = null;
		try {
			//参数转换为键值对String
			String keyValue =mapToString(params);
			url = new URL(path+"?"+keyValue);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestMethod("GET");// 提交模式
			httpURLConnection.setConnectTimeout(connectTime);//连接超时 单位毫秒.
			httpURLConnection.setReadTimeout(readTime);//读取超时 单位毫秒
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.connect();
			StringBuilder sb = new StringBuilder();
			int httpRspCode = httpURLConnection.getResponseCode();
			if (httpRspCode == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				return sb.toString();
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw, true));
			String exception = sw.toString();
			log.error(exception);
		}
		return null;
	}
	
	
	/**
     * 多文件上传的方法
     * 
     * @param path：上传的路径
     * @param uploadFilePaths：需要上传的文件路径，数组
     * @return
     */
    @SuppressWarnings("finally")
    public static String uploadFile(String path, String[] uploadFilePaths) {
        String end = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";

        DataOutputStream ds = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            // 统一资源
            URL url = new URL(path);
            // 连接类的父类，抽象类
            URLConnection urlConnection = url.openConnection();
            // http的连接类
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            httpURLConnection.setDoInput(true);
            // 设置是否向httpUrlConnection输出
            httpURLConnection.setDoOutput(true);
            // Post 请求不能使用缓存
            httpURLConnection.setUseCaches(false);
            // 设定请求的方法，默认是GET
            httpURLConnection.setRequestMethod("POST");
            // 设置字符编码连接参数
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            // 设置字符编码
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            // 设置请求内容类型
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);

            // 设置DataOutputStream
            ds = new DataOutputStream(httpURLConnection.getOutputStream());
            for (int i = 0; i < uploadFilePaths.length; i++) {
                String uploadFile = uploadFilePaths[i];
                String filename = uploadFile.substring(uploadFile.lastIndexOf("//") + 1);
                ds.writeBytes(twoHyphens + boundary + end);
                ds.writeBytes("Content-Disposition: form-data; " + "name=\"file" + i + "\";filename=\"" + filename
                        + "\"" + end);
                ds.writeBytes(end);
                FileInputStream fStream = new FileInputStream(uploadFile);
                int bufferSize = 1024;
                byte[] buffer = new byte[bufferSize];
                int length = -1;
                while ((length = fStream.read(buffer)) != -1) {
                    ds.write(buffer, 0, length);
                }
                ds.writeBytes(end);
                /* close streams */
                fStream.close();
            }
            ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
            /* close streams */
            ds.flush();
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception(
                        "HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                reader = new BufferedReader(inputStreamReader);
                tempLine = null;
                resultBuffer = new StringBuffer();
                while ((tempLine = reader.readLine()) != null) {
                    resultBuffer.append(tempLine);
                    resultBuffer.append("\n");
                }
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (ds != null) {
                try {
                    ds.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return resultBuffer.toString();
        }
    }

	
	
	/**
	 * 将map集合转化为key-value的键值对String
	 * @param params
	 * @return
	 */
	public static  String mapToString(Map<String, ?> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        String prestr = "";
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value =(String) params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }
        return prestr;
    }
	
	
	 /**
     * 获取客户端ip地址
     * @param request
     * @return
     */
    public static String getCliectIp(HttpServletRequest request)
    {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim() == "" || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        // 多个路由时，取第一个非unknown的ip
        final String[] arr = ip.split(",");
        for (final String str : arr) {
            if (!"unknown".equalsIgnoreCase(str)) {
                ip = str;
                break;
            }
        }
        return ip;
    }
    
    /**
     * 获得请求类型 传统还是ajax  
     * @param request
     * @return
     */
    public static String getRequestType(HttpServletRequest request) {
    	String type =request.getHeader("X-Requested-With");
    	if("XMLHttpRequest".equalsIgnoreCase(type)) {
    		return "ajax";
    	}
        return "normal";
    }
	
}
