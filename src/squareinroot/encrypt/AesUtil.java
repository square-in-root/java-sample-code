package squareinroot.encrypt;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class AesUtil {

	/**
	 * publicKey의 길이가 암호화 Bit 수보다 짧은 경우에 대한 처리
	 */
	private static final String DEFAULT_PUBLIC_KEY = "XfNDxC68xsXAqHMc5iCzUuFmvDbVQ2wmf";
	
	
	/**
	 * 
	 * 
	 * @param publicKey 대칭암호키
	 * @param keySize 128, 192, 256
	 * @return
	 */
	public static Key getSecretKey(String publicKey, int keySize) {
		keySize = getCalibratedKeySize(keySize);
		publicKey += AesUtil.DEFAULT_PUBLIC_KEY;
		publicKey = publicKey.substring(0, keySize / 8);
		return (new SecretKeySpec(publicKey.getBytes(), "AES"));
	}
	
	
	public static byte[] encrypt(Key secretKey, String plainText) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return cipher.doFinal(plainText.getBytes());
	}
	
	
	public static byte[] decrypt(Key secretKey, byte[] cipherBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return cipher.doFinal(cipherBytes);
	}
	
	
	private static int getCalibratedKeySize(int keySize) {
		if (keySize > 256) return 256;
		if (keySize > 192) return 192;
		return 128;
	}
}
