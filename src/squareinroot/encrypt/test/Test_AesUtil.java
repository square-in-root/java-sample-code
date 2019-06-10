package squareinroot.encrypt.test;

import java.security.Key;

import squareinroot.encrypt.AesUtil;
import squareinroot.encrypt.Base64Util;

public class Test_AesUtil {

	
	public static void main(String[] args) {
		
		try {
			Key secretKey = AesUtil.getSecretKey("", 128);
			
			String plainText = "Hello 하십니까?";
			System.out.println("plainText : " + plainText);
			
			String cipherText = Base64Util.encode(AesUtil.encrypt(secretKey, plainText));
			System.out.println("cipherText : " + cipherText);
			
			String decryptText = new String(AesUtil.decrypt(secretKey, Base64Util.decode(cipherText)));
			System.out.println("decryptText : " + decryptText);
			
			System.out.println("====================================================");
			
			plainText = "나는 in a peace 합니다.##_o_##";
			System.out.println("plainText : " + plainText);
			
			cipherText = Base64Util.encode(AesUtil.encrypt(secretKey, plainText));
			System.out.println("cipherText : " + cipherText);
			
			decryptText = new String(AesUtil.decrypt(secretKey, Base64Util.decode(cipherText)));
			System.out.println("decryptText : " + decryptText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
