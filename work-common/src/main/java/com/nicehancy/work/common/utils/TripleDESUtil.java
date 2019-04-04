package com.nicehancy.work.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;

/**
 * <p>
 *     3DES加解密
 * <p/>
 *
 * @author hancaiyun
 * @since 2019/4/4 17:13
 **/
@Slf4j
public class TripleDESUtil {

    /**
     * 私有化无参构造器
     */
    private TripleDESUtil() {
    }

    private static final String WORK = "WORK";
    private static Base64 base64 = new Base64();
    private static byte[] myIV = {50, 51, 52, 53, 54, 55, 56, 57};

    /**
     * 通过指定stringKey加密
     * @param input         待加密字符串
     * @param strkey        加密密匙字符串
     * @return              加密后密文
     * @throws Exception    加密异常信息
     */
    private static String desEncrypt(String input, String strkey) throws Exception {

        String cardNo = input;
        strkey = procKey(strkey);
        Base64 base64d = new Base64();
        DESedeKeySpec p8ksp = new DESedeKeySpec(base64d.decode(strkey));
        Key key = SecretKeyFactory.getInstance("DESede").generateSecret(p8ksp);

        input = padding(input);
        if (null == input) {
            return cardNo;
        }

        byte[] plainBytes = input.getBytes("UTF8");
        Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
        SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), "DESede");
        IvParameterSpec ivspec = new IvParameterSpec(myIV);
        cipher.init(1, myKey, ivspec);
        byte[] cipherText = cipher.doFinal(plainBytes);
        String regStr = removeBR(base64.encodeToString(cipherText));

        return CryptTool.byteArrayToHexString(regStr.getBytes());
    }

    /**
     * 通过指定密匙解密
     * @param cipherText       密文
     * @param strkey           密匙
     * @return                 解密后明文
     * @throws Exception       解密异常信息
     */
    private static String desDecrypt(String cipherText, String strkey) throws Exception {
        cipherText = new String(CryptTool.hexString2ByteArray(cipherText));
        strkey = procKey(strkey);
        Base64 base64d = new Base64();
        DESedeKeySpec p8ksp = new DESedeKeySpec(base64d.decode(strkey));
        Key key = SecretKeyFactory.getInstance("DESede").generateSecret(p8ksp);

        byte[] inPut = base64d.decode(cipherText);
        Cipher cipher = Cipher.getInstance("DESede/CBC/NoPadding");
        SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), "DESede");
        IvParameterSpec ivspec = new IvParameterSpec(myIV);
        cipher.init(2, myKey, ivspec);
        byte[] output = removePadding(cipher.doFinal(inPut));

        return new String(output, "UTF8");

    }

    private static String removeBR(String str) {
        StringBuffer sf = new StringBuffer(str);

        for (int i = 0; i < sf.length(); ++i) {
            if (sf.charAt(i) == '\n') {
                sf = sf.deleteCharAt(i);
            }
        }
        for (int i = 0; i < sf.length(); ++i)
            if (sf.charAt(i) == '\r') {
                sf = sf.deleteCharAt(i);
            }

        return sf.toString();
    }

    private static String padding(String str) {
        byte[] oldByteArray;
        try {
            oldByteArray = str.getBytes("UTF8");
            int numberToPad = 8 - oldByteArray.length % 8;
            byte[] newByteArray = new byte[oldByteArray.length + numberToPad];
            System.arraycopy(oldByteArray, 0, newByteArray, 0, oldByteArray.length);
            for (int i = oldByteArray.length; i < newByteArray.length; ++i) {
                newByteArray[i] = 0;
            }
            return new String(newByteArray, "UTF8");
        } catch (UnsupportedEncodingException e) {
            log.error("Crypter.padding UnsupportedEncodingException ", e);
        }
        return null;
    }

    private static byte[] removePadding(byte[] oldByteArray) {
        int numberPaded = 0;
        for (int i = oldByteArray.length; i >= 0; --i) {
            if (oldByteArray[(i - 1)] != 0) {
                numberPaded = oldByteArray.length - i;
                break;
            }
        }

        byte[] newByteArray = new byte[oldByteArray.length - numberPaded];
        System.arraycopy(oldByteArray, 0, newByteArray, 0, newByteArray.length);

        return newByteArray;
    }

    /**
     * 把KEY处理成32位，如果不足，在后面补0，如果超出，截取前32位
     */
    private static String procKey(String key) {
        if (key.length() < 32) {
            while (key.length() < 32) {
                key = key + "0";
            }
            return key;
        } else if (key.length() > 32) {
            return key.substring(0, 32);
        }

        return key;
    }

    /**
     * 加密
     **/
    public static String encrypt(String con) throws Exception {
        return desEncrypt(con, WORK);
    }

    /**
     * 解密
     **/
    public static String decrypt(String con) throws Exception {
        return desDecrypt(con, WORK);
    }
}
