package com.cx.hslib.dao;

import com.cx.common.HsLibRepository;
import com.cx.hslib.bean.BookSetBean;
import org.springframework.stereotype.Component;

/**
 * 图书管理系统后台接口类
 */
@Component
@HsLibRepository
public interface LibAdminDao {
    /**
     * 图书添加类
     * @param bookSetBean
     * @return
     */
    int insertBookSets(BookSetBean bookSetBean);
}
