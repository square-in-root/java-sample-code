package squareinroot.encrypt.junit;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import squareinroot.encrypt.Base64Util;

public class Base64Test {

	@Test
	public void testEncode() throws UnsupportedEncodingException {
		assertEquals("OK", "SGVsbG8hIVxuXHRXb3JsZCEh", Base64Util.encode("Hello!!\\n\\tWorld!!".getBytes("utf-8")));
	}


	@Test
	public void testDecodeStringCharset() throws UnsupportedEncodingException {
		assertEquals("OK", "잘 나오는지요 >.<?", new String(Base64Util.decode("7J6YIOuCmOyYpOuKlOyngOyalCA+Ljw/"), "utf-8"));
	}
}
