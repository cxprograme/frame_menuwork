package com.cx.tool.utils;

import java.util.Random;

/**
 * Created by cx on 18/8/19.
 */
public class CodeUtil {
    // 验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static String createCode(int num){
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<num;i++){
            int n = ran.nextInt(chars.length);
            sb.append(chars[n]);
        }
        return sb.toString();
    }
}
