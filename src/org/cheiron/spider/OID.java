package org.cheiron.spider;

import java.util.UUID;

/**
 * 唯一ID工具类<BR>
 * 以{@link UUID}为基础，返回10位36进制ID<BR>
 * 有<code>main</code>方法，默认循环打印10个ID，可以通过传参形式自定义打印条数
 * 
 * @author Hesper
 * 
 */
public final class OID {

	/**
	 * 取得ID
	 * 
	 * @return ID
	 */
	public final static String get() {
		String[] arrId = UUID.randomUUID().toString().split("-");
		long ll = 0;
		for (String id : arrId) {
			ll += Long.parseLong(id, 16);
		}
		String oid = Long.toString(ll, 36).toUpperCase();
		if (oid.length() != 10)
			return get();
		return oid;
	}

	public static void main(String[] args) {
		int iLength = 10;
		if (args != null && args.length > 0) {
			try {
				iLength = Integer.parseInt(args[0]);
			} catch (Exception e) {
			}
		}
		for (int i = 0; i < iLength; i++) {
			System.out.println(get());
		}
	}

	private OID() {
	}
}
