package com.cx.hslib.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/27.
 */
@Service
public interface UserService {
    /**
     * 获取用户信息
     * @return
     */
    List<Map<String,Object>> getUserInfo(Map<String,Object> attribute);

    /**
     * 插入用户信息
     * @param formAttribute
     * @return
     */
    int insertUserInfo(Map<String,Object> formAttribute);
}
