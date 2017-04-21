/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.Implementist.iReading;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Implementist
 */
public abstract class Encrypt {

    private static final char HEX_DIGITS[] = {'0', '1', '2', '3', '4', '5', '6',
        '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String getCiphertext(String password, String securityStamp) {
        String confusedPassword = confusePassword(password, securityStamp);
        try {
            byte[] btPassword = confusedPassword.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            md5.update(btPassword);
            // 获得密文
            byte[] binaryCiphertext = md5.digest();
            // 把密文转换成十六进制的字符串形式
            return toString(binaryCiphertext);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String getNewSecurityStamp() {
        StringBuilder securityStamp = new StringBuilder();
        Random random = new Random(System.currentTimeMillis());
        for (int index = 0; index < 4; index++) {
            int randomNumber = random.nextInt(255);
            String binaryString = Integer.toBinaryString(randomNumber);
            securityStamp.append(fillZeros(binaryString, 8));
        }
        return securityStamp.toString();
    }

    public static String getUserId() {
        return UUID.randomUUID().toString().toUpperCase();
    }

    //验证要在服务器上验证，此函数只用于测试，实际应用时向服务器上传用户名和密码哈希
    public static Boolean verifyPassword(String passwordHash, String password, String securityStamp) {
        return passwordHash.equals(getCiphertext(password, securityStamp));
    }

    private static String toString(byte[] binaryCiphertext) {
        char chrCiphertext[] = new char[binaryCiphertext.length * 2];
        for (int index = 0, pointer = 0; index < binaryCiphertext.length; index++) {
            byte btCurrentBit = binaryCiphertext[index];
            chrCiphertext[pointer++] = HEX_DIGITS[btCurrentBit >>> 4 & 0xf];
            chrCiphertext[pointer++] = HEX_DIGITS[btCurrentBit & 0xf];
        }
        return new String(chrCiphertext);
    }

    private static String confusePassword(String password, String securityStamp) {
        byte[] decimalPassword = password.getBytes();
        StringBuilder binaryPassword = toBinary(decimalPassword),
                confusedPassword = new StringBuilder();
        //混淆
        for (int index = 0; index < 32; index++) {
            char currentCharOfPassword = binaryPassword.charAt(binaryPassword.length() - index - 1);
            char currentCharOfSecurityStamp = securityStamp.charAt(securityStamp.length() - index - 1);
            binaryPassword.setCharAt(binaryPassword.length() - index - 1, (char) (currentCharOfPassword ^ currentCharOfSecurityStamp - '0'));
        }
        for (int index = 0; index < binaryPassword.length(); index += 8) {
            confusedPassword.append((char) Integer.parseInt(binaryPassword.substring(index, index + 8), 2));
        }
        return confusedPassword.toString();
    }

    private static StringBuilder toBinary(byte[] decimalValue) {
        StringBuilder binaryValue = new StringBuilder();
        for (int index = 0; index < decimalValue.length; index++) {
            binaryValue.append(fillZeros(Integer.toBinaryString(Integer.valueOf(decimalValue[index] + "")), 8));
        }
        return binaryValue;
    }

    //补零函数
    private static String fillZeros(String binaryString, int totalLength) {
        StringBuilder completedString = new StringBuilder();
        for (int Index = 0; Index < totalLength - binaryString.length(); Index++) {
            completedString.append("0");
        }
        completedString.append(binaryString);
        return completedString.toString();
    }
}
