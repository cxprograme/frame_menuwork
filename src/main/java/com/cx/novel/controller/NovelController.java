package com.cx.novel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cx.novel.service.NovelService;
import com.cx.tool.gsonutil.GsonHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/7/8.
 */
@RestController
public class NovelController {
    @Autowired
    private NovelService novelService;

    @RequestMapping(value = "/novel/lists", method = RequestMethod.GET)
    public Object getNovelLists(@RequestParam Map<String,String> formAttribute){
        System.out.println("formAttribute:"+formAttribute);
        int pageNum = Integer.parseInt(formAttribute.get("pageNum"));
        int pageSize = Integer.parseInt(formAttribute.get("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> novelLists = novelService.getNovelInfoLists(formAttribute);
        PageInfo<Map<String,Object>>    pageInfo = new PageInfo<>(novelLists);
        return pageInfo;

    }

    /**
     * 获取首页信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/novel/home",method = RequestMethod.GET)
    public JSONArray getHomeNovel(){
        Map<String,Object> attr = new HashMap<>();
        String flags[] = {"1","2"};
        attr.put("push_flag",flags);
        List<Map<String,Object>> item = novelService.getNovelByArgs(attr);
        String data = GsonHelper.toJson(item);
//        System.out.println("uammenulist:"+uamMenuList);
        JSONArray array = JSON.parseArray(data);
        return array;
    }

    /**
     * 获取小说信息
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "novel/info",method = RequestMethod.GET)
    public Object getNovelInfoById(@RequestParam Map<String,Object> attribute){
        Map<String,Object> info = novelService.getNovelInfoById(attribute);
        return info;
    }


    /**
     * 获取小说目录
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "novel/chapter/list",method = RequestMethod.GET)
    public Object getNovelChapterById(@RequestParam Map<String,String> attribute){
        System.out.println("formAttribute:"+attribute);
        int pageNum = Integer.parseInt(attribute.get("pageNum"));
        int pageSize = Integer.parseInt(attribute.get("pageSize"));
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> novelLists = novelService.getNovelChaptersLists(attribute);
        PageInfo<Map<String,Object>>    pageInfo = new PageInfo<>(novelLists);
        return pageInfo;
    }

    /**
     * 获取小说目录
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "novel/types",method = RequestMethod.GET)
    public Object getNovelTypes(@RequestParam Map<String,String> attribute) {
        List<Map<String,Object>> novelTypes = novelService.getNovelTypes(attribute);
        return  novelTypes;
    }
}

