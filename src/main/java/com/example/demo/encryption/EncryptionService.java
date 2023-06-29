package com.example.demo.encryption;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

	private final Environment environment;
//	private static Environment environment;
	
	@Autowired
    public EncryptionService(Environment environment) {
        this.environment = environment;
    }
	
	
	
	
	public String encrypt(String data){
		
		try {
			String algorithm = environment.getProperty("spring.encrypt.algorithm");
			String secretKey = environment.getProperty("spring.encrypt.key");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
			byte[] encryptBytes = cipher.doFinal(data.getBytes());
			return Base64.getEncoder().encodeToString(encryptBytes);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return data;
	}
	
	public String decrypt(String encryptedData){
		
		try {
			
			String algorithm = environment.getProperty("spring.encrypt.algorithm");
			String secretKey = environment.getProperty("spring.encrypt.key");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
	 		byte[] decryptedBytes = cipher.doFinal(decodedBytes);
			return new String(decodedBytes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	
	}
	
	public static void main(String[] args) {
		
	//	EncryptionService service = new EncryptionService(environment);
		
	//	System.out.println(decrypt("9myMi3iMz1D2LNQmADxZWQ=="));
		
	}
	
}
