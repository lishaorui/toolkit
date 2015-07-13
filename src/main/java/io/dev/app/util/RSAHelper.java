package io.dev.app.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RSA加解密器
 * 
 * @author lsr
 * @version 2014年9月29日
 */
public class RSAHelper {
	private static final Logger logger = LoggerFactory.getLogger(RSAHelper.class);
	public static final String KEY_ALGORTHM_RSA = "RSA";//
	
	private static final int MAX_ENCRYPT_BLOCK = 117;  
	private static final int MAX_DECRYPT_BLOCK = 128; 
	

	public static PublicKey getPublicKey() throws Exception {
		String context = ContextHelper.getClassPath();
		logger.debug("#getPublicKey context:{}", context);
		File keyFile = new File(context + "key", "public.key");
		String key = loadKey(new FileInputStream(keyFile));
		logger.debug("#getPublicKey key:{}", key);
		// 对公钥解密
		byte[] keyBytes = Base64.decodeBase64(key);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM_RSA);
		PublicKey publicKey = keyFactory.generatePublic(keySpec);
		return publicKey;
	}

	public static PrivateKey getPrivateKey(int keyNumber) throws Exception {
		String context = ContextHelper.getClassPath();
		logger.debug("#getPrivateKey context:{}", context);
		File keyFile = new File(context + "key", "private.key");
		String key = loadKey(new FileInputStream(keyFile));
		logger.debug("#getPrivateKey key:{}", key);
		// 对私钥解密
		byte[] keyBytes = Base64.decodeBase64(key);
		// PKCS#8
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORTHM_RSA);
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		return privateKey;
	}

	/**
	 * 公钥加密
	 * 
	 * @param data
	 *            待加密数据
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptByPublicKey(String data) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORTHM_RSA);
		cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());
		
		byte[] bytes = data.getBytes();
		int inputLen = bytes.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段加密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {  
                cache = cipher.doFinal(bytes, offSet, MAX_ENCRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(bytes, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_ENCRYPT_BLOCK;  
        }  
        byte[] encryptedData = out.toByteArray();  
        out.close();  
        return encryptedData; 
	}

	/**
	 * 私钥解密
	 * 
	 * @param data
	 *            待解密数据
	 * @return
	 * @throws Exception
	 */
	public static String decryptByPrivateKey(int keyNumber, byte[] encryptedData) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORTHM_RSA);
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKey(keyNumber));
		
		int inputLen = encryptedData.length;  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        int offSet = 0;  
        byte[] cache;  
        int i = 0;  
        // 对数据分段解密  
        while (inputLen - offSet > 0) {  
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {  
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);  
            } else {  
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);  
            }  
            out.write(cache, 0, cache.length);  
            i++;  
            offSet = i * MAX_DECRYPT_BLOCK;  
        }  
        byte[] decryptedData = out.toByteArray();  
        out.close();  
        return new String(decryptedData);  
	}

	public static String loadKey(InputStream in) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(in));
        String readLine= null;
        StringBuilder sb= new StringBuilder();
        while((readLine= br.readLine())!=null){
            if(readLine.charAt(0)=='-'){
                continue;
            }else{
                sb.append(readLine);
                sb.append('\r');
            }
		}
		return sb.toString();
	}
}
