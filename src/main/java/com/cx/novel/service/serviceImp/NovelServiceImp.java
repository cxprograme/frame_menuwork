package com.cx.novel.service.serviceImp;

import com.cx.novel.dao.NovelDao;
import com.cx.novel.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/7/8.
 */
@Component
public class NovelServiceImp implements NovelService{
    @Autowired
    private NovelDao novelDao;


    @Override
    public List<Map<String, Object>> getNovelInfoLists(Map<String, String> attribute) {
        return novelDao.getNovelInfoLists(attribute);
    }

    @Override
    public List<Map<String, Object>> getNovelByArgs(Map<String, Object> attribute) {
        return novelDao.getNovelByArgs(attribute);
    }

    @Override
    public Map<String, Object> getNovelInfoById(Map<String, Object> attibute) {
        return novelDao.getNovelInfoById(attibute);
    }

    @Override
    public List<Map<String, Object>> getNovelChapterById(Map<String, Object> attibute) {
        return novelDao.getNovelChapterById(attibute);
    }

    @Override
    public List<Map<String, Object>> getNovelChaptersLists(Map<String, String> attribute) {
        return novelDao.getNovelChaptersLists(attribute);
    }

    @Override
    public List<Map<String, Object>> getNovelTypes(Map<String, String> attribute) {
        return novelDao.getNovelTypes(attribute);
    }


}
