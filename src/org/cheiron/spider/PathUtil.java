package org.cheiron.spider;

import java.net.URL;

/**
 * 路径工具类
 * 
 * @author Hesper
 * 
 */
public final class PathUtil {
	/**
	 * 类的跟路径
	 */
	public final static String ROOT;

	private PathUtil() {
	}

	static {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("");
		ROOT = url.getPath();
	}

	public static void main(String[] args) {
		System.out.println(ROOT);
	}
}
