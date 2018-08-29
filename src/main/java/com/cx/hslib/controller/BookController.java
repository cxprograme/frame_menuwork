package com.cx.hslib.controller;

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

    @LoginRequired
    @ResponseBody
    @RequestMapping(value = "lib/book/borrow",method = RequestMethod.GET)
    public MessageBean borrowBook(){
        return new MessageBean<String>(0,"失败");
    }


}
