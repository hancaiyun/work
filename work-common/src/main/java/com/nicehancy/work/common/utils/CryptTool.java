package com.nicehancy.work.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <p>
 *      工具类
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/4 17:23
 **/
@Slf4j
public class CryptTool {

    private CryptTool() {
        throw new IllegalAccessError("Utility class");
    }

    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "A", "B", "C", "D", "E", "F"   };

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */

    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString().toUpperCase();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 生成3DES密钥.
     *
     * @param key_byte seed key
     * @throws Exception
     * @return javax.crypto.SecretKey Generated DES key
     */
    public static SecretKey genDESKey(byte[] key_byte) throws Exception {
        return new SecretKeySpec(key_byte, "DESede");
    }

    private static SecretKey genDESKey() throws Exception {
        // 使用固定key
        String keyStr = "$1#2@f3&4~6%7!a+*cd(e-h)";
        // 3DES 24 bytes key
        byte key_byte[] = keyStr.getBytes();
        return new SecretKeySpec(key_byte, "DESede");
    }

    public static SecretKey genDESKey(String key) throws Exception {
        // 3DES 24 bytes key
        byte key_byte[] = key.getBytes();
        return new SecretKeySpec(key_byte, "DESede");
    }

    /**
     * 将表示16进制值的字符串转换为byte数组， 和public static String byteArrayToHexString(byte[] b)
     * 互为可逆的转换过程
     *
     * @param strIn 需要转换的字符串
     * @return 转换后的byte数组
     * @throws Exception 本方法不处理任何异常，所有异常全部抛出
     * @author LiGuoQing
     */
    public static byte[] hexString2ByteArray(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;

        // 两个字符表示一个字节，所以字节数组长度是字符串长度除以2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }

    /**
     * 3DES 解密(byte[]).
     *
     * @param key SecretKey
     * @param crypt byte[]
     * @return byte[]
     */
    public static byte[] desDecrypt(SecretKey key, byte[] crypt) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(crypt);
    }

    /**
     * 3DES 解密(String).
     *
     * @param key SecretKey
     * @param crypt byte[]
     * @return byte[]
     */
    public static String desDecrypt(SecretKey key, String crypt) throws Exception {
        return byteArrayToHexString(desDecrypt(key, crypt.getBytes("UTF-8")));
    }

    /**
     * 3DES加密(byte[]).
     *
     * @param key SecretKey
     * @param src byte[]
     * @return byte[]
     */
    public static byte[] desEncrypt(SecretKey key, byte[] src) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(src);
    }

    /**
     * 3DES加密(String).
     *
     * @param key SecretKey
     * @param src byte[]
     * @throws Exception
     * @return byte[]
     */
    public static String desEncrypt(SecretKey key, String src) throws Exception {
        return byteArrayToHexString(desEncrypt(key, src.getBytes("UTF-8")));
    }

    /**
     * MD5 摘要计算(byte[]).
     *
     * @param src byte[]
     * @throws Exception
     * @return byte[] 16 bit digest
     */
    public static byte[] md5Digest(byte[] src) throws Exception {
        // MD5 is 16 bit message digest
        java.security.MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
        return alg.digest(src);
    }

    /**
     * MD5 摘要计算(String).
     *
     * @param src String
     * @return String
     */
    public static String md5Digest(String src) throws Exception {
        return byteArrayToHexString(md5Digest(src.getBytes()));
    }

    /**
     * MD5 解密
     *
     * @param src String
     * @return String
     */
    public static String md5Enc(String src) throws Exception {
        return byteArrayToHexString(md5Digest(src.getBytes()));
    }

    /**
     * BASE64 编码.
     *
     * @param src String inputed string
     * @return String returned string
     */
    public static String base64Encode(String src) {
        return new Base64().encodeToString(src.getBytes());
    }

    /**
     * BASE64 编码(byte[]).
     *
     * @param src byte[] inputed string
     * @return String returned string
     */
    public static String base64Encode(byte[] src) {
        return new Base64().encodeToString(src);
    }

    /**
     * BASE64 解码.
     *
     * @param src String inputed string
     * @return String returned string
     */
    public static String base64Decode(String src) {
        Base64 decoder = new Base64();
        try {
            return byteArrayToHexString(decoder.decode(src));
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * BASE64 解码(to byte[]).
     *
     * @param src String inputed string
     * @return String returned string
     */
    public static byte[] base64DecodeToBytes(String src) {
        Base64 decoder = new Base64();
        try {
            return decoder.decode(src);
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *  先3DES加密，再base64编码
     *
     * @param key  密钥
     * @param str 需要加密的字符串
     */
    public static String des3Base64Enc(SecretKey key, String str) throws Exception {
        if (key == null) {
            key = genDESKey();
        }
        byte[] enc = desEncrypt(key, str.getBytes());
        return base64Encode(enc);
    }

    /**
     *  先base64解码,再3DES解密
     *
     * @param key  密钥
     * @param str 需要加密的字符串
     */
    public static String des3Base64Dec(SecretKey key, String str) throws Exception {
        if (key == null) {
            key = genDESKey();
        }
        byte[] decbase64 = base64DecodeToBytes(str);
        byte[] dec = desDecrypt(key, decbase64);
        return new String(dec, "UTF-8");
    }
}
