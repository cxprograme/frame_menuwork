package com.cx.novel.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/7/8.
 */
@Service
public interface NovelService {

    /**
     * 获取小说所有信息
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getNovelInfoLists(Map<String,String> attribute);


    /**
     * 根据参数获取小说信息
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getNovelByArgs(Map<String,Object> attribute);

    /**
     * 获取小说信息
     * @param attibute
     * @return
     */
    Map<String,Object> getNovelInfoById(Map<String,Object> attibute);

    /**
     * 获取小说章节
     * @param attibute
     * @return
     */
    List<Map<String,Object>> getNovelChapterById(Map<String,Object> attibute);

    /**
     * 获取小说章节
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getNovelChaptersLists(Map<String,String> attribute);

    /**
     * 获取小说类型
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getNovelTypes(Map<String,String> attribute);
}
