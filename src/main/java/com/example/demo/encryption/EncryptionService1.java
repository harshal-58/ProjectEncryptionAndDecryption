package com.example.demo.encryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService1 {

	static String algorithm = "AES";
	static String secretKey = "MyNameIsHarshalJ";
	
	// or 
	
	public static String encrypt(String data) {
		
		try {
			
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(),algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encryptBytes = cipher.doFinal(data.getBytes());
			return Base64.getEncoder().encodeToString(encryptBytes);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}

	public static String decrypt(String encryptedData) {
		
		try {
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
			byte[] decryptedBytes = cipher.doFinal(decodedBytes);
			return new String(decryptedBytes);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	}
	
	public static void main(String[] args) {
		System.out.println(decrypt("9myMi3iMz1D2LNQmADxZWQ=="));
		System.out.println(encrypt("Harshal@123"));
	}
	
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
