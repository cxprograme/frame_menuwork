/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : menudb

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 08/28/2018 07:39:23 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `uam_custom_menus`
-- ----------------------------
DROP TABLE IF EXISTS `uam_custom_menus`;
CREATE TABLE `uam_custom_menus` (
  `MENU_ID` varchar(36) NOT NULL COMMENT '菜单ID',
  `USER_ID` varchar(36) NOT NULL COMMENT '用户ID',
  `MENU_NAME` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `MENU_TYPE` char(1) NOT NULL COMMENT '菜单类型 0:''folder''  1:''menu''',
  `IS_TRUNK` char(1) NOT NULL COMMENT '新主页中标示主干',
  `PAGE_ID` text COMMENT '菜单对应页面id',
  `MODULE_ID` varchar(36) DEFAULT NULL COMMENT '菜单所属模块',
  `SUB_MENU_ID_LIST` text COMMENT '子菜单',
  `IS_NEW_NODE` char(1) DEFAULT NULL COMMENT '是否为新增节点',
  `MODULE_EN_NAME` varchar(128) DEFAULT NULL COMMENT '模块英文名',
  `PARENT_MENU_ID` varchar(36) DEFAULT NULL COMMENT '上级菜单ID',
  `ORDER_ID` decimal(10,0) DEFAULT NULL COMMENT '排序序列',
  `CUSTOMER_TYPE` char(1) NOT NULL COMMENT '0:非客户自定义菜单  1:客户自定义菜单',
  PRIMARY KEY (`MENU_ID`,`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='uam_custom_menus-';

-- ----------------------------
--  Table structure for `uam_menus`
-- ----------------------------
DROP TABLE IF EXISTS `uam_menus`;
CREATE TABLE `uam_menus` (
  `MENU_ID` varchar(36) NOT NULL COMMENT '菜单ID',
  `MENU_NAME` varchar(128) NOT NULL COMMENT '菜单名称',
  `PAGE_ID` text COMMENT '界面号',
  `NEED_SHOW` decimal(10,0) NOT NULL COMMENT '用户菜单权限',
  `MENU_HINT` text COMMENT '菜单提示',
  `MENU_IMAGE_PATH` text COMMENT '菜单图片路径',
  `REMARK` text COMMENT '备注',
  `MENU_KIND` varchar(64) NOT NULL COMMENT '0：不支持重复打开 1：支持重复打开',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='uam_menus-';

-- ----------------------------
--  Table structure for `uam_menus_expend`
-- ----------------------------
DROP TABLE IF EXISTS `uam_menus_expend`;
CREATE TABLE `uam_menus_expend` (
  `menu_id` varchar(36) NOT NULL DEFAULT '',
  `js_text` varchar(128) DEFAULT ' ',
  `procedure_name` varchar(128) DEFAULT NULL,
  `lcrxml_text` varchar(128) DEFAULT ' ',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
