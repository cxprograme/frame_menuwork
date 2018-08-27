package com.cx.hslib.controller;

import com.cx.hslib.frame.init.WebMvcConfigurer;
import com.cx.hslib.models.sys.SysUser;
import com.cx.hslib.service.UserService;
import com.cx.tool.bean.MessageBean;
import com.cx.tool.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cx on 18/8/19.
 */
@RestController
@RequestMapping(value = "hs")
public class MailController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "lib/email",method = RequestMethod.GET)
    public MessageBean testMail(@RequestParam Map<String,Object> attribute,HttpSession session){

        String toAddress = attribute.get("to_address").toString();

        MessageBean messageBean = null;
        messageBean = MailUtil.sendMail(toAddress,"[邮件]测试","尊敬的客户:您的反馈我们已经收到",session);

        return messageBean;
    }

    @ResponseBody
    @RequestMapping(value = "lib/check/email",method = RequestMethod.GET)
    public  MessageBean checkCode(@RequestParam Map<String,Object> attribute,HttpSession session){
        MessageBean messageBean =null;
        String code = (String) session.getAttribute(WebMvcConfigurer.SESSION_CODE);
        //获取传递的编码
        String sCode = attribute.get("code").toString();
        //邮箱
        String email = attribute.get("mail").toString();
        Map<String,Object> userInfo = null;
        if (code!=null&&sCode!=null && sCode.equals(code)){
            /*SysUser sysUserOne = (SysUser)session.getAttribute(WebMvcConfigurer.SESSION_KEY);

            if (sysUserOne==null){
                SysUser sysUser = new SysUser();
                session.setAttribute(WebMvcConfigurer.SESSION_KEY,sysUser);
            }*/
            userInfo = (Map<String, Object>) session.getAttribute(WebMvcConfigurer.SESSION_KEY);
            if (userInfo==null) {
                userInfo = new HashMap<>();
                userInfo.put("mail", email);
                session.setAttribute(WebMvcConfigurer.SESSION_KEY, userInfo);
            }
            //判断数据库中是否保存了相同email的用户
            //如果有就不插入,没有就插入数据
            List<Map<String,Object>> user = userService.getUserInfo(attribute);
            if (user.size() >0){
                messageBean =new MessageBean<String>(0,"验证成功",user.get(0).toString());
            }else{
                String person = "用户"+ UUID.randomUUID().toString().substring(5);
                attribute.put("person_name",person);
                int count = userService.insertUserInfo(attribute);
            }
           return messageBean;
        }
        return  new MessageBean<String>(1,"验证失败");

    }
}
