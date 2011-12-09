package org.cheiron.spider;

/**
 * boolean工具类
 * 
 * @author Hesper
 * 
 */
public final class BoolUtil {
	private BoolUtil() {
	}

	/**
	 * 转换为Boolean
	 * 
	 * @param value
	 *            字符类变量
	 * @param falseValue
	 *            <CODE>false</CODE>标识值
	 * @return 如果<CODE>value</CODE>等于<CODE>falseValue</CODE>返回
	 *         <CODE>false</CODE><BR>
	 *         否则返回<CODE>true</CODE>
	 */
	public final static boolean toBoolean(Comparable<?> value, Comparable<?> falseValue) {
		if (value == null)
			return false;
		if (value instanceof Boolean)
			return ((Boolean) value).booleanValue();
		return !(value == falseValue);
	}

	/**
	 * 转换为Boolean
	 * 
	 * @param value
	 *            数值变量
	 * @return 如果传入数值变量为<CODE>0</CODE>返回<CODE>false</CODE><BR>
	 *         否则返回 <CODE>true</CODE>
	 */
	public final static boolean toBoolean(Comparable<?> value) {
		return toBoolean(value, 0);
	}

}
