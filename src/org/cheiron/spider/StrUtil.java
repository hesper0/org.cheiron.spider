package org.cheiron.spider;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public final class StrUtil {
	private StrUtil() {
	}

	/**
	 * 判断字符串数组是否皆为空
	 * 
	 * @param strs
	 *            字符串数组
	 * @return 是否皆为空
	 */
	public static final boolean isEmpty(String... strs) {
		if (strs == null || strs.length <= 0)
			return true;
		for (String str : strs) {
			if (StringUtils.isEmpty(str))
				return true;
		}
		return false;
	}

	/**
	 * 取得多个资源文件
	 * 
	 * @param propertiesFilePath
	 *            资源文件路径
	 * @return 多个资源文件合成的{@link Properties}
	 * @throws IOException
	 *             找不到时资源文件时
	 */
	public static final Properties getProperties(String... propertiesFilePath) throws IOException {
		Properties p = new Properties();
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		for (String pfp : propertiesFilePath) {
			p.load(cl.getResourceAsStream(pfp));
		}
		return p;
	}

	/**
	 * 是否是正确的Email格式
	 * 
	 * @param email
	 *            待判断字符串
	 * @return <CODE>true</CODE>是<BR>
	 *         <CODE>false</CODE>不是
	 */
	public static final boolean isEmail(String email) {
		email = StringUtils.trim(email);
		String check = "^([a-z0-9A-Z]+[-|\\._]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(check);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 首字母大写
	 * 
	 * @param sIn
	 *            待处理字符
	 * @return 首字母大写后的字符
	 */
	public static final String capitalize(String sIn) {
		sIn = StringUtils.trim(sIn);
		if ("".equals(sIn))
			return "";
		sIn = StringUtils.lowerCase(sIn);
		sIn = StringUtils.capitalize(sIn);
		return sIn;
	}

}
