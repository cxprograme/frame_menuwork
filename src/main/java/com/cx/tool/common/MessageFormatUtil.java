package com.cx.tool.common;

import com.cx.tool.common.exception.CommonException;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * 信息格式化工具
 * @author xujin
 *
 */
public class MessageFormatUtil {
    /**
     * 异常信息配置文件路径
     */
    private static final String EXCEPTION_PROPERTIES_FILE_PATH = "/bizErrorMessage.properties";
    /**
     * 异常信息配置文件路径(中文)
     */
    private static final String EXCEPTION_PROPERTIES_FILE_PATH_CN = "/bizErrorMessage_zh_CN.properties";
    /**
     * 异常信息配置文件路径(英文)
     */
    private static final String EXCEPTION_PROPERTIES_FILE_PATH_EN = "/bizErrorMessage_en_US.properties";

    private static Properties resources = new Properties();
    /**
     *	根据Property键值格式化信息
     *
     * @param key
     * @param args
     *
     * @return
     */
    public static String format(String key, Object[] args) {
        String value = resources.getProperty(key);
        if (value == null) {
            return key;
        } else {
            return MessageFormat.format(value, args);
        }
    }
    static {
        try {
            String messagePath = "";
            String language = LanguageUtil.getLanguage("language","zh_CN");//国际化语言
            if (language.equals("zh_CN")) {
                // 汉语-中国
                messagePath =EXCEPTION_PROPERTIES_FILE_PATH_CN;
            } else if (language.equals("en_US")) {
                // 英语-美国
                messagePath =EXCEPTION_PROPERTIES_FILE_PATH_EN;
            }  else {
                messagePath =EXCEPTION_PROPERTIES_FILE_PATH;
            }
            InputStream stream =CommonException.class
                    .getResourceAsStream(messagePath);

            resources.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

