package com.cx.hslib.dao;

import com.cx.common.HsLibRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/18.
 */
@Component
@HsLibRepository
public interface LibDao {
    /**
     * 测试书籍类
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getBookLists(Map<String,Object> attribute);
}
