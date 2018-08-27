package com.cx.menu.dao;

import com.cx.common.MenuRepository;

import java.util.Map;

/**
 * Created by cx on 18/5/28.
 */
@MenuRepository
public interface UamMenusExpendDao {
    /**
     * menu 扩展信息添加
     * @param formAttribute
     * @return
     */
    int insertMenusExpend(Map<String,String> formAttribute);
}
