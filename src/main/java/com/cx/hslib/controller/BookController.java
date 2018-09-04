package com.cx.hslib.controller;

import com.cx.hslib.bean.Comment;
import com.cx.hslib.dao.LibDao;
import com.cx.hslib.frame.annotation.CurrentUser;
import com.cx.hslib.frame.annotation.LoginRequired;
import com.cx.hslib.models.sys.SysUser;
import com.cx.hslib.service.BookListService;
import com.cx.tool.bean.MessageBean;
import com.cx.tool.utils.MailUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/18.
 */
@RequestMapping(value = "hs")
@RestController
public class BookController {

    @Autowired
    private BookListService bookListService;

    /**
     *获取图书列表
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lib/book/list",method = RequestMethod.GET)
    public Object getBookLists(@RequestParam Map<String,Object> attribute){
        //System.out.println("formAttribute:"+attribute);
        /*int pageNum = Integer.parseInt(attribute.get("pageNum").toString());
        int pageSize = Integer.parseInt(attribute.get("pageSize").toString());
        PageHelper.startPage(pageNum,pageSize);
        List<Map<String,Object>> novelLists = bookListService.getBookLists(attribute);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(novelLists);
        return pageInfo;*/
        List<Map<String,Object>>  booklist = bookListService.getBookLists(attribute);
        return booklist;

    }

//    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "lib/book/borrow",method = RequestMethod.GET)
    public MessageBean borrowBook(){
        return new MessageBean<String>(0,"失败");
    }

    /**
     * 书籍操作事件,包括订阅 1 取消订阅 -1 续借 3
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lib/book/operate",method = RequestMethod.POST)
    public MessageBean operateBook(@RequestBody Map<String,Object> attribute){
        MessageBean messageBean = null;


        if (attribute.size()>0){
            String orderType = attribute.get("order_type").toString();
            if ("1".equals(orderType)) {
                int bookSetId = (int) attribute.get("bookset_id");
                List<Map<String, Object>> noBorrowList = bookListService.getNoBorrowBooks(attribute);
                if (noBorrowList.size() > 0) {
                    int bookId = (int) noBorrowList.get(0).get("book_id");
                    attribute.put("book_id", bookId);
                    bookListService.operateBook(attribute);
                    //获取数据状态
                    int msg_no = (int) attribute.get("p_error_type");
                    messageBean = new MessageBean<String>(msg_no, "操作提示");
                }
            }else if("-1".equals(orderType)||"-3".equals(orderType)){
                //续借或者取消订阅的情况
                bookListService.operateBook(attribute);
                //获取数据状态
                int msg_no = (int) attribute.get("p_error_type");
                messageBean = new MessageBean<String>(msg_no, "操作提示");
            }

        }
        messageBean = new MessageBean<String>(1,"操作失败");
        return messageBean;
    }

    /**
     * 评论表
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lib/book/comment",method = RequestMethod.POST)
    public MessageBean comment(@RequestBody Map<String,Object> attribute){
        Comment comment =new Comment();
        if (attribute.size()>0){
            comment.setBookId(Integer.parseInt(attribute.get("book_id").toString()));
            comment.setPersonId(Integer.parseInt(attribute.get("person_id").toString()));
            comment.setMarks(attribute.get("marks").toString());
            comment.setComments(attribute.get("comments").toString());
            int count = bookListService.insertComment(comment);
            if (count >0){
                int commentId = comment.getCommentId();
            }
        }

        return null;
    }


    /**
     * 获取我的订单信息
     * @param attribute
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lib/book/my",method = RequestMethod.GET)
    public Object getMyOrderInfo(@RequestParam Map<String,Object> attribute){
        List<Map<String,Object>> myOrderLists = new ArrayList<>();
        if (attribute.size()>0){
//            int person_id =Integer.parseInt(attribute.get("person_id").toString());
//            attribute.put("person_id",person_id);
            myOrderLists = bookListService.getMyOrderInfo(attribute);
        }
        return myOrderLists;
    }
}
