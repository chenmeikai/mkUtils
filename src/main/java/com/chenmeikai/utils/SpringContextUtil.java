///**   
// * Copyright © 2018  
// * @Package: com.inesv.alarm.utils   
// * @date: 2018年4月12日 下午4:40:19 
// */
//package com.chenmeikai.utils;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//
///**    
// * @Description:TODO 
// * @author: cmk
// * @date:   2018年4月12日 下午4:40:19      
// */
//public class SpringContextUtil implements ApplicationContextAware {  
//	  
//    // Spring应用上下文环境  
//    private static ApplicationContext applicationContext;  
//  
//    /** 
//     * 实现ApplicationContextAware接口的回调方法。设置上下文环境 
//     *  
//     * @param applicationContext 
//     */  
//    public void setApplicationContext(ApplicationContext applicationContext) {  
//        SpringContextUtil.applicationContext = applicationContext;  
//    }  
//  
//    /** 
//     * @return ApplicationContext 
//     */  
//    public static ApplicationContext getApplicationContext() {  
//        return applicationContext;  
//    }  
//  
//    /** 
//     * 获取对象 
//     *  
//     * @param name 
//     * @return Object
//     * @throws BeansException 
//     */  
//    public static Object getBean(String name) throws BeansException {  
//        return applicationContext.getBean(name);  
//    }  
//}