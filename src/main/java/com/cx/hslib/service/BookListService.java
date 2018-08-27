package com.cx.hslib.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/18.
 */
@Service
public interface BookListService {
    /**
     * 测试书籍类
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getBookLists(Map<String,Object> attribute);
}
