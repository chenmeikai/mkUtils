/**
 * 
 */
package com.chenmeikai.utils.RSA;
import java.io.FileInputStream;  
import java.security.PrivateKey;  
import java.security.PublicKey;  
  
public class SecurityUtils {  
	
	/**
	 * 打印公钥和私钥
	 */
	public static void printSecretKey() {
		RSAUtils.createSecretKey();
	}
    
    /**
     * 生成密钥对文件
     * @param path
     */
    public static void createSecretKeyFile(String path) {
    	RSAUtils.createKeyPair(path);
    }
    
    
    /**
     * 公钥(String)加密
     * @param plainTest
     * @param publicString
     * @return
     * @throws Exception
     */
    public static String encryptByPublicString(String plainTest,String publicString) throws Exception{  
        PublicKey publicKey = RSAUtils.loadPublicKey(publicString);  
        // 加密  
        byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);  
        String afterencrypt = Base64Utils.encode(encryptByte);  
        return afterencrypt;
    } 
    
    
    /**
     * 公钥(文件)加密 
     * @param plainTest 待加密的明文
     * @param publicPath 公钥文件的路径
     * @return 加密后的密文
     * @throws Exception
     */
     public static String encryptByPublicFile(String plainTest,String publicPath) throws Exception{  
         FileInputStream inPublic = new FileInputStream(publicPath);  
         PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);  
         // 加密  
         byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);  
         String afterencrypt = Base64Utils.encode(encryptByte);  
         return afterencrypt;
     } 
     
     /**
      * 私钥(String)加密
      * @param plainTest
      * @param privateString
      * @return
      * @throws Exception
      */
     public static String encryptByprivateString(String plainTest,String privateString) throws Exception{  
         PrivateKey privateKey = RSAUtils.loadPrivateKey(privateString);  
         // 加密  
         byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), privateKey);  
         String afterencrypt = Base64Utils.encode(encryptByte);  
         return afterencrypt;
     } 
     
     /**
      * 私钥(文件)加密 
      * @param plainTest 待加密的明文
      * @param privatePath 私钥文件的路径
      * @return 加密后的密文
      * @throws Exception
      */
      public static String encryptByPrivateFile(String plainTest,String privatePath) throws Exception{  
          FileInputStream inPrivate = new FileInputStream(privatePath);  
          PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);  
          // 加密  
          byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), privateKey);  
          String afterencrypt = Base64Utils.encode(encryptByte);  
          return afterencrypt;
      } 
     
     /**
      *  私钥(String)解密
      * @param cipherText
      * @param privateString
      * @return
      * @throws Exception
      */
     public static String decryptByPrivateString(String cipherText,String privateString) throws Exception{  
         // 从文件中得到私钥  
        PrivateKey privateKey = RSAUtils.loadPrivateKey(privateString);  
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), privateKey);  
        String decryptStr = new String(decryptByte,"utf-8");  
        return decryptStr;  
    }
     
    /**
     * 私钥(文件)解密 
     * @param cipherText 密文
     * @param path 私钥文件路径
     * @return 解密后的明文
     * @throws Exception
     */
    public static String decryptByPrivateFile(String cipherText,String privatePath) throws Exception{  
         // 从文件中得到私钥  
        FileInputStream inPrivate = new FileInputStream(privatePath);  
        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);  
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), privateKey);  
        String decryptStr = new String(decryptByte,"utf-8");  
        return decryptStr;  
    }  
    
    /**
     *  公钥(String)解密
     * @param cipherText
     * @param publicString
     * @return
     * @throws Exception
     */
    public static String decryptByPublicString(String cipherText,String publicString) throws Exception{  
        // 从文件中得到公钥  
       PublicKey publicKey = RSAUtils.loadPublicKey(publicString);  
       byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), publicKey);  
       String decryptStr = new String(decryptByte,"utf-8");  
       return decryptStr;  
   }
    
   /**
    * 公钥(文件)解密 
    * @param cipherText 密文
    * @param publicPath 公钥文件路径
    * @return 解密后的明文
    * @throws Exception
    */
   public static String decryptByPublicFile(String cipherText,String publicPath) throws Exception{  
        // 从文件中得到公钥  
       FileInputStream inPublic = new FileInputStream(publicPath);  
       PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);  
       byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), publicKey);  
       String decryptStr = new String(decryptByte,"utf-8");  
       return decryptStr;  
   }  
    
}  