package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {
	public static String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest messageDigest;
		messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] hashedPassword = messageDigest.digest(password.getBytes("UTF-8")); 
		
		StringBuilder hexdecimalStringPassword = new StringBuilder();
	     for (byte hashedPasswordDigit : hashedPassword) {
	    	 hexdecimalStringPassword.append(String.format("%02X", 0xFF & hashedPasswordDigit));
	     }
	     
	     return  hexdecimalStringPassword.toString();
	}
}
