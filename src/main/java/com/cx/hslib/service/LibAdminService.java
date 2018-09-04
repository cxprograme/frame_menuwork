package com.cx.hslib.service;

import com.cx.common.HsLibRepository;
import com.cx.hslib.bean.BookSetBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface LibAdminService {
    /**
     * 图书添加类
     * @param bookSetBean
     * @return
     */
    int insertBookSets(BookSetBean bookSetBean);
}
