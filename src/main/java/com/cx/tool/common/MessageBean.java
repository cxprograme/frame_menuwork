package com.cx.tool.common;



/**
 * 系统消息实体
 * @author xujin
 *
 */
public class MessageBean {
    private boolean isRead = false;


    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    /**
     * 默认消息键值
     */
    public final static String DEFAULT_MESSAGE_KEY = "info.undefined";
    /**
     * 消息键值
     */
    private String key;

    /**
     * 消息格式化参数
     */
    private Object[] params;

    /**
     * 消息分类
     */
    private MessageCategory category;

    //构建方法
    public MessageBean(){
        this(DEFAULT_MESSAGE_KEY,null,MessageCategory.INFO);
    }

    public MessageBean(String key){
        this(key,null,MessageCategory.INFO);
    }

    public MessageBean(String key,MessageCategory category){
        this(key,null,category);
    }

    public MessageBean(String key,Object[] params){
        this(key,params,MessageCategory.INFO);
    }

    public MessageBean(String key,Object[] params,MessageCategory category){
        if(StringUtil.isNotEmpty(key)){
            this.key = key;
        }
        if(null==params){
            this.params = new Object[]{};
        }else{
            this.params = params;
        }
        this.category = category;
    }

    /**
     * 获取消息内容
     * @return
     */
    public String getMessage(){
        return MessageFormatUtil.format(key, params);
    }

    /**
     * 获取消息分类
     * @return
     */
    public MessageCategory getCategory(){
        return category;
    }

    /**
     * 获取消息键值
     * @return
     */
    public String getKey(){
        return key;
    }

    /**
     * 获取消息格式化参数
     * @return
     */
    public Object[] getParams(){
        return params;
    }

}

