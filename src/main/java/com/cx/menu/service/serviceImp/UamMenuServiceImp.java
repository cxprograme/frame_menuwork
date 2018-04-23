package com.cx.menu.service.serviceImp;

import com.cx.menu.dao.UamMenuDao;
import com.cx.menu.entity.UamMenu;
import com.cx.menu.service.UamMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class UamMenuServiceImp implements UamMenuService {
    @Autowired
    private UamMenuDao uamMenuDao;

    @Override
    public List<UamMenu> getUamMenuLists() {
        return uamMenuDao.getAllMenu();
    }

    @Override
    public UamMenu getUamMenuByMenuid(String menuId) {
        return null;
    }

    @Override
    public List<Map<String,String>> getAllMenuByMap(){
        return uamMenuDao.getAllMenuByMap();
    }

    @Override
    public int modifyMenuByObj(Map<String,String> formAttribute){
        return uamMenuDao.modifyMenuByObj(formAttribute);
    }

    @Override
    public int insertMenus(Map<String,String> formAttribute){
        return uamMenuDao.insertMenus(formAttribute);
    }

    @Override
    public int deleteObjByMid(Map<String, String> formAttribute){
        return uamMenuDao.deleteObjByMid(formAttribute);
    }

    @Override
    public List<Map<String, Object>> getParentOrSubMenus(Map<String, String> formAttribute) {
        return uamMenuDao.getParentOrSubMenus(formAttribute);
    }

    @Override
    public Map<String, Object> getMenuDetailsByArgs(Map<String, String> formAttribute) {
        return uamMenuDao.getMenuDetailsByArgs(formAttribute);
    }
}
