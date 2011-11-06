package org.cheiron.spider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间处理类
 * 
 * @author Hesper
 * 
 */
public final class DateTimeUtil {
	public final static String PATTERN_YYYY_MM_DD = "yyyy-MM-dd";

	private DateTimeUtil() {
		super();
	}

	public final static String format(Date date, String pattern) {
		return format(date, new SimpleDateFormat(pattern));
	}

	public final static String format(Date date, DateFormat dateFormat) {
		return dateFormat.format(date);
	}

	public static void main(String[] args) {
		System.out.println(format(new Date(), PATTERN_YYYY_MM_DD));
	}
}
