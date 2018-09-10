package com.chenmeikai.utils.date;

/**
 * 全局公共参数
 *
 * @author meikai
 * @version 2017年11月24日 下午3:45:21
 */
public final class DateFormat {

    /**
     * 私有化构造函数，不可被实例化，保持单例
     */
    private DateFormat() {
    }

    /**
     * 日期格式配比
     */
    public static final String[] DATE_PATTERNS = new String[]{"yyyy",
            "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd",
            "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss"};
    /**
     * 日期格式配比:yyyy-MM-dd
     */
    public static final String DATE_PATTERN1 = "yyyy-MM-dd";
    /**
     * 日期格式配比:yyyyMMdd
     */
    public static final String DATE_PATTERN2 = "yyyyMMdd";
    /**
     * 日期格式配比:yyyy/MM/dd
     */
    public static final String DATE_PATTERN3 = "yyyy/MM/dd";
    /**
     * 日期格式配比:yyyy-MM-dd HH:mm:ss
     */
    public static final String DATE_PATTERN4 = "yyyy-MM-dd HH:mm:ss";
    /**
     * 日期格式配比:DATE_PATTERN5
     */
    public static final String DATE_PATTERN5 = "yyyyMMddHHmmss";
    /**
     * 日期格式配比:yyyy/MM/dd HH:mm:ss
     */
    public static final String DATE_PATTERN6 = "yyyy/MM/dd HH:mm:ss";

}
