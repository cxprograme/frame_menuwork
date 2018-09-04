package com.cx.hslib.bean;

import java.util.Date;

/**
 * 图书集
 */
public class BookSetBean {

    private int bookSetsId;
    private String bookName;
    private String author;
    private int classId;
    private String picture;
    private String description;
    private String isRecommond;
    private Date   updateTime;
    private int totalAmount;
    private int leftAmount;

    public int getBookSetsId() {
        return bookSetsId;
    }

    public void setBookSetsId(int bookSetsId) {
        this.bookSetsId = bookSetsId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsRecommond() {
        return isRecommond;
    }

    public void setIsRecommond(String isRecommond) {
        this.isRecommond = isRecommond;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getLeftAmount() {
        return leftAmount;
    }

    public void setLeftAmount(int leftAmount) {
        this.leftAmount = leftAmount;
    }

    @Override
    public String toString() {
        return "BookSetBean{" +
                "bookSetsId=" + bookSetsId +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", classId=" + classId +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", isRecommond='" + isRecommond + '\'' +
                ", updateTime=" + updateTime +
                ", totalAmount=" + totalAmount +
                ", leftAmount=" + leftAmount +
                '}';
    }
}

