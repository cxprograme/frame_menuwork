package com.cx.menu.service;

import com.cx.menu.entity.UamMenu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UamMenuService {

    List<UamMenu> getUamMenuLists();

    UamMenu getUamMenuByMenuid(String menuId);

    List<Map<String,String>> getAllMenuByMap();

    int modifyMenuByObj(Map<String,String> formAttribute);

    int insertMenus(Map<String,String> formAttribute);

    int deleteObjByMid(Map<String,String> formAttribute);

    /**
     * 获取父节点和子节点
     * @param argMap
     * @return
     */
    List<Map<String,Object>> getParentOrSubMenus(Map<String, String> formAttribute);
    /**
     * 获取详细信息
     * @param formAttribute
     * @return
     */
    Map<String,Object> getMenuDetailsByArgs(Map<String,String> formAttribute);

}

