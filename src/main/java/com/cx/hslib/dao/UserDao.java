package com.cx.hslib.dao;

import com.cx.common.HsLibRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/27.
 */
@Component
@HsLibRepository
public interface UserDao {
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
