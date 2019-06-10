package squareinroot.encrypt;

import java.io.UnsupportedEncodingException;

public class Base64Util {
    
    /* 
     * 'Base64' class implemented in java since version 1.8.
     * If the java version is lower than 1.8, we recommend using 'Apache Commons Codec'.
     * 
     * # Oracle official document : https://docs.oracle.com/javase/8/docs/api/java/util/Base64.html
     * 
     */
	
	public static String encode(byte [] input) {
		java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
		return new String(encoder.encode(input));
    }
	
	public static String encode(String input) {
		return encode(input.getBytes());
	}
	
	public static String encode(String input, String charsetName) throws UnsupportedEncodingException {
		return encode(input.getBytes(charsetName));
	}
    
	public static byte [] decode(byte[] input) {
    	java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
    	return decoder.decode(input);
    }
	
	public static byte [] decode(String input) throws UnsupportedEncodingException {
    	return decode(input.getBytes());
    }
}
