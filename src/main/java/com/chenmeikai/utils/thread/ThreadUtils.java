/**   
 * Copyright © 2018 
 * @Package: Thread.java 
 * @author: Administrator   
 * @date: 2018年3月18日 下午5:10:34 
 */
package com.chenmeikai.utils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description:TODO
 * @author: cmk
 * @date: 2018年3月18日 下午5:10:34
 */
public class ThreadUtils {

    static ExecutorService cachedThreadPool;

    static ExecutorService fixedThreadPool;

    static ScheduledExecutorService scheduledThreadPool;

    static ExecutorService singleThreadPool;
    
    static int MAX_THREAD=5;
    
    /**
     * 用来创建一个可缓存线程池，该线程池没有长度限制，对于新的任务，如果有空闲的线程，则使用空闲的线程执行，如果没有，则新建一个线程来执行任务。如果线程池长度超过处理需要，可灵活回收空闲线程
     * @param runnable
     * @return
     */
    static ExecutorService cachedThreadRun(Runnable runnable) {
        if (cachedThreadPool == null)
            cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.submit(runnable);
        return cachedThreadPool;
    }
    
    /**
     * 用来创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。定长线程池的大小通常根据系统资源进行设置
     * @param runnable
     * @return
     */
    public static ExecutorService fixedThreadRun(Runnable runnable) {
        if (fixedThreadPool == null)
            fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime()
                    .availableProcessors());
        fixedThreadPool.submit(runnable);
        return fixedThreadPool;
    }
    
    /**
     * 用来创建一个定长线程池，并且支持定时和周期性的执行任务
     * @param runnable
     * @param delay 延迟执行
     * @param unit  时间单位
     * @return
     */
    public static ExecutorService scheduledThreadRun(Runnable runnable, long delay, TimeUnit unit) {
        if (scheduledThreadPool == null)
            scheduledThreadPool = Executors.newScheduledThreadPool(MAX_THREAD);
        scheduledThreadPool.schedule(runnable, delay, unit);
        return scheduledThreadPool;
    }
    
    /**
     * 用来创建一个定长线程池，并且支持定时和周期性的执行任务
     * @param runnable
     * @param delay 延迟执行
     * @param repeat 重复执行
     * @param unit  时间单位
     * @return
     */
    public static ExecutorService scheduledThreadRun(Runnable runnable, long delay,int repeat, TimeUnit unit) {
        if (scheduledThreadPool == null)
            scheduledThreadPool = Executors.newScheduledThreadPool(MAX_THREAD);
        scheduledThreadPool.scheduleAtFixedRate(runnable, delay,repeat, unit);
        return scheduledThreadPool;
    }
    
    /**
     * 用来创建一个单线程化的线程池，它只用唯一的工作线程来执行任务，一次只支持一个，所有任务按照指定的顺序执行
     * @param runnable
     * @return
     */
    public static ExecutorService singleThreadRun(Runnable runnable) {
        if (singleThreadPool == null)
            singleThreadPool = Executors.newSingleThreadExecutor();
        singleThreadPool.submit(runnable);
        return singleThreadPool;
    }

  
    public static void main(String[] args) {
        final Long startTime = System.currentTimeMillis();
        ExecutorService executorService = null;

        for (int i = 0; i < 1000000; i++) {
//            System.out.println(finalI);
            final int finalI = i;
            Runnable task = () -> System.out.println(finalI);
            executorService = ThreadUtils.fixedThreadRun(task);
        }

        if (executorService != null) {
            executorService.shutdown();
        }

        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("所有的子线程都结束了！");
                break;
            }
        }

        final Long stopTime = System.currentTimeMillis();
        System.out.println("---------------------------");
        System.out.println(stopTime - startTime);


    }

}