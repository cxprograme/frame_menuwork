package com.cx.menu.dao;

import com.cx.common.MenuRepository;
import com.cx.menu.entity.UamMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Component
@MenuRepository
public interface UamMenuDao  {

    List<UamMenu> getAllMenu();
    List<Map<String,String>> getAllMenuByMap();

    int modifyMenuByObj(Map<String, String> formAttribute);

    int insertMenus(Map<String, String> formAttribute);

    int deleteObjByMid(Map<String, String> formAttribute);

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




