package com.cx.menu.controller;

import com.cx.menu.entity.UamMenu;
import com.cx.menu.service.UamMenuService;
import com.cx.tool.bean.MessageBean;
import com.cx.tool.gsonutil.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    private UamMenuService uamMenuService;


/*    @RequestMapping(value = "/menus",method = RequestMethod.GET)
    public List<UamMenu> getAllMenus(){
        return uamMenuService.getUamMenuLists();
    }*/

    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public String getAllMenuByMap(){
        List<Map<String,String>> uamMenuList = uamMenuService.getAllMenuByMap();
        String data = GsonHelper.toJson(uamMenuList);
        System.out.println("uammenulist:"+uamMenuList);
        return data;
    }

    @RequestMapping(value = "/menus/mid",method = RequestMethod.PUT,consumes = "application/json; charset=utf-8")
    public Object modifyMenuByObj(@RequestBody Map<String, String> formAttribute){
        MessageBean messageBean = null;
        int num = uamMenuService.modifyMenuByObj(formAttribute);
        if (num > 0) {
            messageBean = new MessageBean<String>(0,"更新成功");
        }
        return messageBean;
    }

    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    public Object insertMenu(@RequestBody Map<String,String> formAttribute){
        MessageBean messageBean = null;
        if (!formAttribute.isEmpty()){
            int num = uamMenuService.insertMenus(formAttribute);
            if (num > 0){
                messageBean = new MessageBean<String>(0,"新增成功");
            }
        }
        return messageBean;
    }

    @RequestMapping(value = "/menus/mid", method = RequestMethod.DELETE)
    public Object deleteObjByMid(@RequestBody Map<String, String> formAttribute){
        MessageBean messageBean = null;
        if (!formAttribute.isEmpty()){
            int num = uamMenuService.deleteObjByMid(formAttribute);
            if (num > 0){
                messageBean = new MessageBean<String>(0,"删除成功");
            }
        }
        return messageBean;
    }

    @RequestMapping(value = "/menus/psmenus",method = RequestMethod.GET)
    public Object getParentOrSubMenus(@RequestParam Map<String,String> formAttribute){
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
        System.out.println("uammenulist:"+uamMenuList);
        return data;
    }
}


