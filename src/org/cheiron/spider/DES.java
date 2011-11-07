package org.cheiron.spider;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * DES加密工具类
 * 
 * @author Hesper
 * 
 */
public class DES {
	/**
	 * 加密算法
	 */
	private static final String Algorithm = "DES";
	/**
	 * 加密文件位置
	 */
	private static final String SECRET_KEY_FILENAME = PathUtil.ROOT + "/resources/SECRET_KEY.key";
	private Cipher encryptCipher = null;
	private Cipher decryptCipher = null;

	/**
	 * 使用指定密钥构建加密类
	 * 
	 * @param key
	 *            密钥字符串
	 */
	public DES(String key) {
		try {
			encryptCipher = Cipher.getInstance(Algorithm);
			encryptCipher.init(Cipher.ENCRYPT_MODE, makeSecretKey(key));
			decryptCipher = Cipher.getInstance(Algorithm);
			decryptCipher.init(Cipher.DECRYPT_MODE, makeSecretKey(key));
		} catch (Exception e) {
			Log.error(this, e);
		}
	}

	/**
	 * 加密类构造函数<BR>
	 * 使用默认Key加密
	 */
	public DES() {
		try {
			encryptCipher = Cipher.getInstance(Algorithm);
			encryptCipher.init(Cipher.ENCRYPT_MODE, makeSecretKey());
			decryptCipher = Cipher.getInstance(Algorithm);
			decryptCipher.init(Cipher.DECRYPT_MODE, makeSecretKey());
		} catch (Exception e) {
			Log.error(this, e);
		}
	}

	/**
	 * 加密字符串
	 * 
	 * @param strPlainText
	 *            明文
	 * @return 密文
	 */
	public String encrypt(String strPlainText) {
		try {
			byte[] cipherByte = encryptCipher.doFinal(strPlainText.getBytes("UTF8"));
			return byte2hex(cipherByte);
		} catch (Exception e) {
			Log.error(this, "加密失败");
			Log.error(this, e);
			return null;
		}
	}

	/**
	 * 解密字符串
	 * 
	 * @param strCipherText
	 *            密文
	 * @return 明文
	 */
	public String decrypt(String strCipherText) {
		try {
			byte[] b = hex2byte(strCipherText.getBytes());
			byte[] cipherByte = decryptCipher.doFinal(b);
			return new String(cipherByte, "UTF8");
		} catch (Exception e) {
			Log.error(this, "解密失败");
			Log.error(this, e.getLocalizedMessage());
			return null;
		}
	}

	private String byte2hex(byte[] b) { // 一个字节的数，
		// 转成16进制字符串
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			// 整数转成十六进制表示
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs = hs + "0" + stmp;
			else
				hs = hs + stmp;
		}
		return hs.toUpperCase(); // 转成大写
	}

	private byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0)
			throw new IllegalArgumentException("长度不是偶数");
		byte[] b2 = new byte[b.length / 2];
		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节
			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}
		return b2;
	}

	private Key makeSecretKey(String strKey) throws Exception {
		byte[] arrBTmp = strKey.getBytes();
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];

		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		// 生成密钥
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	/**
	 * 用于生成Des加密密钥
	 * 
	 * @return 密钥
	 */
	private SecretKey makeSecretKey() {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		SecretKey deskey = null;
		try {
			// 查找并解析密钥文件
			fis = new FileInputStream(SECRET_KEY_FILENAME);
			ois = new ObjectInputStream(new BufferedInputStream(fis));
			deskey = (SecretKey) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			Log.warn(this, "查找并解析密钥文件失败:" + SECRET_KEY_FILENAME);
			deskey = null;
		}
		if (deskey == null) {
			// 生成密钥
			KeyGenerator keygen;
			try {
				keygen = KeyGenerator.getInstance(Algorithm);
				deskey = keygen.generateKey();
				ObjectOutputStream oos = null;
				FileOutputStream fos = null;
				fos = new FileOutputStream(SECRET_KEY_FILENAME);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(deskey);
				oos.close();
				fos.close();
			} catch (Exception e) {
				Log.error(this, "生产密钥文件失败");
				deskey = null;
			}
		}
		return deskey;
	}
}
