package kr.or.ddit.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class EncryptTest {
	
	@Test
	void testRSA() throws Exception {
		String plain = "암호화하기 전의 단문 데이터";
		byte[] input = plain.getBytes();
		Cipher cipher = Cipher.getInstance("RSA");
		KeyPairGenerator pairGen = KeyPairGenerator.getInstance("RSA");
		pairGen.initialize(2048);
		KeyPair pair = pairGen.genKeyPair();
		PrivateKey privateKey = pair.getPrivate();
		PublicKey publicKey = pair.getPublic();
		
		// 전자서명용이면?
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] encrypted = cipher.doFinal(input);
		String encoded = Base64.getEncoder().encodeToString(encrypted);
		
		log.info("RSA 암호화 결과 : {}", encoded);
		
		// --> 암호문과 공개키 전송
		byte[] decoded = Base64.getDecoder().decode(encoded);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] decrypted = cipher.doFinal(decoded);
		String afterPlain = new String(decrypted);
		
		log.info("RSA 복호화 결과 : {}", afterPlain);
	}
	
	@Test
	void testAES() throws Exception {
		String plain = "암호화하기 전의 장문 데이터";
		byte[] input = plain.getBytes();
		Cipher cipher= Cipher.getInstance("AES/CBC/PKCS5Padding");
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		SecretKey key = keyGen.generateKey();
		
		// 첫번째 블럭의 역할을 할 초기 백터 생성(128bit)
		byte[] iv = new byte[128/8]; 
		new SecureRandom().nextBytes(iv);
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		byte[] encrypted = cipher.doFinal(input);
		
		String encoded = Base64.getEncoder().encodeToString(encrypted);
		log.info("AES 암호화 결과 : {}", encoded);
		
		// 반대쪽에 암호문과 비밀키와 초기벡터를 함께 전송해야함
		
		// 원문데이터 복원과정
		byte[] decoded = Base64.getDecoder().decode(encoded);
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] decrypted = cipher.doFinal(decoded);
		String afterPlain= new String(decrypted);
		log.info("AES 복호화 결과 : {}", afterPlain);
	}
	
	@Test
	void testHash() throws NoSuchAlgorithmException {
		MessageDigest md =  MessageDigest.getInstance("SHA-512");
		String plain = "java";
		byte[] input = plain.getBytes();
		byte[] encryipted = md.digest(input);
		log.info("해쉬 길이 : {}", encryipted.length * 8);
		
		String encoded = Base64.getEncoder().encodeToString(encryipted);
		log.info("단방향 암호화 결과 : {}", encoded);
	}

	@Test
	void testEncoding() throws Exception {
		String original = "인코딩전 원문";
		String encoded = URLEncoder.encode(original, "UTF-8");
		log.info("encoded : {}", encoded);
	}
	
	@Test
	void testDecoding() throws UnsupportedEncodingException {
		String encoded = "%EC%9D%B8%EC%BD%94%EB%94%A9%EC%A0%84+%EC%9B%90%EB%AC%B8";
		String decoded = URLDecoder.decode(encoded, "UTF-8");
		log.info("decoded : {}", decoded);
	}

}
