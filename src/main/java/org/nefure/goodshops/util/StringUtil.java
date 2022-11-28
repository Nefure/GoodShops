package org.nefure.goodshops.util;

/**
 * @author nefure
 * @since 2022/11/24 9:12
 */
public class StringUtil {

    /**
     * 删除字符串中所有空格
     */
    public static String compact(String origin){
        int len = origin.length();
        StringBuilder builder = new StringBuilder(Math.max(len>>1,16));
        char[] chars = origin.toCharArray();
        for (char ch : chars) {
            if (ch != ' '){
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static boolean isBlank(String str){
        return str == null || str.isBlank();
    }

}
