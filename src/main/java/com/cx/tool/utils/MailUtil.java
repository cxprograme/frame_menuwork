package com.cx.tool.utils;

import com.cx.hslib.frame.init.WebMvcConfigurer;
import com.cx.hslib.models.sys.SysUser;
import com.cx.tool.bean.MessageBean;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sun.tools.internal.xjc.util.CodeModelClassFactory;
import org.apache.commons.mail.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;

/**
 * Created by cx on 18/8/18.
 */
public class MailUtil {
    private static String _USER_NAME_ = "cxprograme12";
    private static String _PASSWORD_ = "21031080wdv";
    private static String _SMTP_ADDRESS_ = "smtp.163.com";
    private final static int _SMTP_PORT_SSL_ = 25;
    private static String from = "cxprograme12@163.com";

    protected static final Logger logger = Logger.getLogger(MailUtil.class);
    public static MessageBean sendMail(String toAddress, String subject, String content,HttpSession session){
        MessageBean messageBean=null;
        SysUser sysUser = null;
        HtmlEmail email = new HtmlEmail();
        email.setHostName(_SMTP_ADDRESS_);
        email.setSmtpPort(_SMTP_PORT_SSL_);
        email.setCharset("UTF-8");
        email.setAuthenticator(new DefaultAuthenticator(_USER_NAME_, _PASSWORD_));
        email.setSSLOnConnect(true);
        try {
            //生成验证码
            String code = CodeUtil.createCode(4);
            //发件人
            email.setFrom(from,"cxpro");
            email.setSubject(subject);
            email.setMsg(content+":"+code);
            //收件人
            email.addTo(toAddress);
            email.send();
                session.setAttribute(WebMvcConfigurer.SESSION_CODE,code);
            if (logger.isDebugEnabled()) {

                logger.debug(email.getFromAddress() + " 发送邮件到 " + email.getToAddresses());
            }
            messageBean = new MessageBean<String>(0,"邮件发送成功");


        } catch (EmailException e) {
            messageBean = new MessageBean<String>(1,"邮件发送失败");
            e.printStackTrace();
            logger.debug(email.getFromAddress() + " 发送邮件到 " + email.getToAddresses()+"失败");
        }
        return messageBean;
    }
}
