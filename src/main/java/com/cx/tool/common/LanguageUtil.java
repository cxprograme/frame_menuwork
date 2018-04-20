package com.cx.tool.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.cx.tool.common.exception.CommonException;

/**
 *
 * @author zhouzx
 *
 */
public class LanguageUtil {

    /**
     * 国家化语言配置文件路径
     */
    private static final String LANGUAGE_FILE_PATH = "/languageConfig.properties";

    private static Properties languageProperties = new Properties();
    static {
        try {

            InputStream stream = CommonException.class
                    .getResourceAsStream(LANGUAGE_FILE_PATH);
            languageProperties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取国际化语言信息
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getLanguage(String key, String defaultValue) {
        String pattern = languageProperties.getProperty(key);
        if (pattern != null) {
            return pattern;
        } else {
            return defaultValue;
        }

    }
}
