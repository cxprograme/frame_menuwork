package com.cx.menu.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 菜单实体类
 */
public class UamMenu {
    private String menuId;

    private String menuName;

    private String pageId;

    private Integer needShow;

    private String menuHint;

    private String menuImagePath;

    private String remark;

    private Integer menuKind;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public Integer getNeedShow() {
        return needShow;
    }

    public void setNeedShow(Integer need_show) {
        this.needShow = need_show;
    }

    public String getMenuHint() {
        return menuHint;
    }

    public void setMenuHint(String menuHint) {
        this.menuHint = menuHint;
    }

    public String getMenuImagePath() {
        return menuImagePath;
    }

    public void setMenuImagePath(String menuImagePath) {
        this.menuImagePath = menuImagePath;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMenuKind() {
        return menuKind;
    }

    public void setMenuKind(Integer menuKind) {
        this.menuKind = menuKind;
    }

    @Override
    public String toString() {
        return "UamMenu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", pageId='" + pageId + '\'' +
                ", need_show=" + needShow +
                ", menuHint='" + menuHint + '\'' +
                ", menuImagePath='" + menuImagePath + '\'' +
                ", remark='" + remark + '\'' +
                ", menuKind=" + menuKind +
                '}';
    }
}


