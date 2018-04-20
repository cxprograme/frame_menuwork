package com.cx.tool.bean;

public class MessageBean<T> {
	private int msg_no;
	private String msg_info;
	private T msg_result;

	public MessageBean() {

	}

	public MessageBean(int msg_no, String msg_info) {
		this.msg_no = msg_no;
		this.msg_info = msg_info;
	}
	
	public MessageBean(int msg_no, String msg_info,T msg_result) {
		this.msg_no = msg_no;
		this.msg_info = msg_info;
		this.msg_result = msg_result;
	}

	public int getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(int msg_no) {
		this.msg_no = msg_no;
	}

	public String getMsg_info() {
		return msg_info;
	}

	public void setMsg_info(String msg_info) {
		this.msg_info = msg_info;
	}
	
	public T getMsg_result() {
		return msg_result;
	}

	public void setMsg_result(T msg_result) {
		this.msg_result = msg_result;
	}

	public String toHtml() {
		return "<msg_no>" + msg_no + "</msg_no>" + "<msg_info>" + msg_info
				+ "</msg_info>" + "<msg_result>" + msg_result + "</msg_result>";
	}
}
