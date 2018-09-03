package com.cx.hslib.dao;

import com.cx.common.HsLibRepository;
import com.cx.hslib.bean.Comment;
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

    /**
     * 书籍操作类
     * @param attribute
     * @return
     */
    Map<String,Object> operateBook(Map<String,Object> attribute);

       /**
     * 获取未借图书
     * @param attribute
     * @return
     */
    List<Map<String,Object>> getNoBorrowBooks(Map<String,Object> attribute);

    /**
     * 插入评论信息
     * @param comment
     * @return
     */
    int insertComment(Comment comment);

    /**
     * 获取我的订单信息
     * @param attribute
     * @return
     */
    List<Map<String,Object>>  getMyOrderInfo(Map<String,Object> attribute);
}
