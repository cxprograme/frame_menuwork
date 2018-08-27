package com.cx.menu.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by cx on 18/5/29.
 */
@Service
public interface UamMenusExpendService {


    /**
     * menu 扩展信息添加
     * @param formAttribute
     * @return
     */
    int insertMenusExpend(Map<String,String> formAttribute);
}
