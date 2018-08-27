package com.cx.hslib.controller;

import com.cx.hslib.frame.annotation.CurrentUser;
import com.cx.hslib.frame.annotation.LoginRequired;
import com.cx.hslib.models.sys.SysUser;
import com.cx.hslib.service.BookListService;
import com.cx.hslib.service.UserService;
import com.cx.tool.bean.MessageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by cx on 18/8/27.
 * 用户信息控制器
 */
@RequestMapping(value = "user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookListService bookListService;
    /**
     * 用户登录信息
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "lib/test",method = RequestMethod.GET)
    public MessageBean borrowBook(@RequestParam Map<String,Object> attribute){
        //判断数据库中是否保存了相同email的用户
        //如果有就不插入,没有就插入数据
        MessageBean messageBean = null;
        List<Map<String,Object>> user = userService.getUserInfo(attribute);
        //List<Map<String,Object>> user = bookListService.getBookLists(attribute);
        if (user.size() >0){
            messageBean =new MessageBean<String>(1,"存在用户信息",user.toString());
        }else{
            int count = userService.insertUserInfo(attribute);
        }
        return new MessageBean<String>(0,"失败");
    }

}
