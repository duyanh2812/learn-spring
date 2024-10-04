package com.ndanh.learn.spring.security.jwt;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@SpringBootApplication
public class JwtApplication {

//	public static void main(String[] args) {
//		SpringApplication.run(JwtApplication.class, args);
//	}

	public static void main(String[] args) {
		// Generate a SecretKey
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		System.out.println("SecretKey: " + secretKey);
		// Encode SecretKey to Base64
		String base64EncodedKey = encodeSecretKeyToBase64(secretKey);
		System.out.println("Base64 Encoded SecretKey: " + base64EncodedKey);

		// Decode Base64 back to SecretKey
		SecretKey decodedKey = decodeBase64ToSecretKey(base64EncodedKey);
		System.out.println("Decoded SecretKey: " + decodedKey);
	}

	// Method to encode SecretKey to Base64
	public static String encodeSecretKeyToBase64(SecretKey secretKey) {
		byte[] keyBytes = secretKey.getEncoded();
		return Base64.getEncoder().encodeToString(keyBytes);
	}

	// Method to decode Base64 to SecretKey
	public static SecretKey decodeBase64ToSecretKey(String base64Key) {
		byte[] keyBytes = Base64.getDecoder().decode(base64Key);
		return new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256"); // Use the correct algorithm here
	}
}
