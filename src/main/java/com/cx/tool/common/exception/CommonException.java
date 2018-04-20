package com.cx.tool.common.exception;


import com.cx.tool.common.Contants;
import com.cx.tool.common.MessageBean;
import com.cx.tool.common.StringUtil;

import java.sql.SQLException;




public class CommonException extends RuntimeException {
    private static final long serialVersionUID = -6853310712844466349L;
    private String error_no = "";
    private String error_info = "";
    private String error_id = "";
    private String error_sysinfo = "";
    private String error_pathinfo = "";


    public String getError_no() {
        return error_no;
    }

    public void setError_no(String error_no) {
        this.error_no = error_no;
    }

    public String getError_info() {
        String message = super.getMessage();
        if (StringUtil.isNotEmpty(error_info)) {
            message = error_info;
        }
        return message;
    }

    public void setError_info(String error_info) {
        this.error_info = error_info;
    }

    public String getError_id() {
        return error_id;
    }

    public void setError_id(String error_id) {
        this.error_id = error_id;
    }

    public String getError_sysinfo() {
        return error_sysinfo;
    }

    public void setError_sysinfo(String error_sysinfo) {
        this.error_sysinfo = error_sysinfo;
    }

    public String getError_pathinfo() {
        return error_pathinfo;
    }

    public void setError_pathinfo(String error_pathinfo) {
        this.error_pathinfo = error_pathinfo;
    }

    public void setError_pathinfo(String old_error_pathinfo,String new_error_pathinfo) {
        StringBuffer pathInfo = new StringBuffer();
        pathInfo.append(new_error_pathinfo).append(old_error_pathinfo);
        this.error_pathinfo = pathInfo!=null?pathInfo.toString():null;
    }
    public CommonException() {
    }

    public CommonException(Throwable cause) {
        if (cause instanceof SQLException){//sql异常
            SQLException sql= (SQLException)cause;
            this.error_id = sql.getErrorCode()+"";
            this.error_sysinfo = sql.getMessage();
            this.error_no = Contants.ERR_SQLERR;
            MessageBean ms = new MessageBean(Contants.ERR_SQLERR);
            this.error_info = ms.getMessage();

        }else{
            if(cause instanceof Exception){//系统出错
                Exception  daoce= (Exception)cause;
                this.error_id =Contants.ERR_SYSERR;
                this.error_sysinfo=daoce.getMessage();
                this.error_no=Contants.ERR_SYSERR;
                MessageBean ms = new MessageBean(Contants.ERR_SYSERR);
                this.error_info = ms.getMessage();
            }
        }
    }


}
