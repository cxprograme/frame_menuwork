package com.cx.menu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cx.menu.service.UamMenuService;
import com.cx.tool.gsonutil.GsonHelper;
import com.fasterxml.jackson.core.util.InternCache;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/4/30.
 */
@RestController
public class MenuAdminController {

    @Autowired
    private UamMenuService uamMenuService;

    @RequestMapping(value = "/menus/admin",method = RequestMethod.GET)
    public Object getMenuDetailsByArgs(@RequestParam Map<String,String> formAttribute){
        System.err.println("formAttribute:"+formAttribute);
        int  pageNum = Integer.parseInt(formAttribute.get("pageNum"));
        int  pageSize = Integer.parseInt(formAttribute.get("pageSize"));
//        PageHelper.startPage(2,5);
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> menus = uamMenuService.getParentOrSubMenus(formAttribute);
        PageInfo<Map<String,Object>>    pageInfo = new PageInfo<>(menus);
//        String data = GsonHelper.toJson(menus);
//        String data = GsonHelper.toJson(pageInfo);
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/menus/admin/tree",method = RequestMethod.GET)
    public JSONArray getAdminMen(@RequestParam Map<String,String> formAttribute){
//        System.out.println("data:"+formAttribute);
        List<Map<String,Object>> uamMenuList = uamMenuService.getParentOrSubMenus(formAttribute);

        for(Map<String,Object> item:uamMenuList){
            String menuId = item.get("menu_id").toString();
            Map<String,String> subFormAttribute = new HashMap<>();
            subFormAttribute.put("menu_type",formAttribute.get("menu_type"));
            subFormAttribute.put("user_id",formAttribute.get("user_id"));
            subFormAttribute.put("parent_menu_id",menuId);
            List<Map<String,Object>> subUamMemuList = uamMenuService.getParentOrSubMenus(subFormAttribute);
            item.put("sub_menu",subUamMemuList);
            item.put("hidden",true);
        }
        String data = GsonHelper.toJson(uamMenuList);
//        System.out.println("uammenulist:"+uamMenuList);
        JSONArray array = JSON.parseArray(data);
        return array;
    }
}
