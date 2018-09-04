package com.cx.hslib.controller;

import com.alibaba.druid.sql.ast.statement.SQLForeignKeyImpl;
import com.cx.hslib.bean.BookSetBean;
import com.cx.hslib.dao.LibAdminDao;
import com.cx.tool.bean.MessageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 图书管理后台
 */
@RequestMapping(value = "hs/back")
@Controller
public class BookAdminController {

    /**
     * 封面上传
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lib/upload")
    public MessageBean upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request){
        MessageBean<String> messageBean = null;
        String originalFileName = picture.getOriginalFilename();
        //获取文件在服务器的储存位置
        //String path = request.getSession().getServletContext().getRealPath("D:/files/images");
        String path ="D:/Dev_Document/Front_workspace/vue-lib/static/image/";
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        //根据日期来创建对应文件夹
        String datePath=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
        String tarPath=path+datePath;
        //如果不存在,创建文件夹
        File f = new File(tarPath);
        if(!f.exists()){
            f.mkdirs();
        }

        //新生成的文件名称
        //生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        String fileName=uuid+"."+type;
        String pathName = tarPath+fileName;
        //在指定路径下创建一个文件
        File targetFile = new File(pathName);
        //保存在数据库中的文件路径
        String virPath = "/image/"+datePath+fileName;
        try {
            picture.transferTo(targetFile);
            //将文件在服务器的存储路径返回
            messageBean = new MessageBean<>();
            messageBean.setMsg_no(0);
            messageBean.setMsg_info("上传成功");
            messageBean.setMsg_result(virPath);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            messageBean = new MessageBean<String>(1,"上传失败");
        }
        return messageBean;
    }

    @ResponseBody
    @RequestMapping(value = "/lib/book/add",method = RequestMethod.POST)
    public MessageBean addBook(@RequestBody Map<String,Object> attribute){
        //需要添加图书集以及图书信息
        BookSetBean bookSetBean = new BookSetBean();
        bookSetBean.setAuthor(attribute.get("author").toString());
        bookSetBean.setBookName(attribute.get("book_name").toString());
        bookSetBean.setDescription(attribute.get("description").toString());
        bookSetBean.setIsRecommond(attribute.get("is_recommond").toString());
        bookSetBean.setPicture(attribute.get("picture").toString());
        bookSetBean.setUpdateTime((Date) attribute.get("update_time"));
        //获取有多少编号
        List<Map<String,Object>> bookNos = (List<Map<String, Object>>) attribute.get("bookNos");
        bookSetBean.setTotalAmount(bookNos.size());
        bookSetBean.setTotalAmount(bookNos.size());
        return null;
    }

}

