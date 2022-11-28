package org.nefure.goodshops.util;

import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * @author nefure
 * @since 2022/11/24 9:20
 */
public class Coder {

    public static String DIGEST_ALGORITHM = "SHA-256";

    public static final String SALT = "@GoodShopsSalt";

    @SneakyThrows
    public static String digest(String msg){
        msg = msg + SALT;
        MessageDigest digest = MessageDigest.getInstance(DIGEST_ALGORITHM);
        digest.update(msg.getBytes(StandardCharsets.UTF_8));
        return byte2Hex(digest.digest());
    }

    /**
     * 将byte转为16进制
     */
    public static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }
}
