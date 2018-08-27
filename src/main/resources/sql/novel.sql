/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50709
 Source Host           : localhost
 Source Database       : novel

 Target Server Type    : MySQL
 Target Server Version : 50709
 File Encoding         : utf-8

 Date: 08/28/2018 07:39:08 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `novel_chpater`
-- ----------------------------
DROP TABLE IF EXISTS `novel_chpater`;
CREATE TABLE `novel_chpater` (
  `novel_id` varchar(64) NOT NULL DEFAULT ' ' COMMENT '小说编号',
  `chpater_id` varchar(64) NOT NULL DEFAULT ' ' COMMENT '章节id',
  `chapter_name` varchar(64) NOT NULL DEFAULT ' ' COMMENT '章节名称',
  `chpater_content` text NOT NULL COMMENT '章节内容',
  `order_id` int(10) NOT NULL DEFAULT '0' COMMENT '小说章节排序',
  `chpater_url` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `novel_info`
-- ----------------------------
DROP TABLE IF EXISTS `novel_info`;
CREATE TABLE `novel_info` (
  `novel_type` varchar(4) NOT NULL DEFAULT ' ',
  `novel_name` varchar(20) NOT NULL DEFAULT ' ',
  `novel_id` varchar(64) NOT NULL DEFAULT ' ',
  `novel_describe` varchar(2000) NOT NULL DEFAULT ' ',
  `novel_img` varchar(200) NOT NULL DEFAULT ' ',
  `img_url` varchar(200) NOT NULL DEFAULT ' ',
  `push_flag` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT ' ',
  `novel_author` varchar(20) NOT NULL DEFAULT ' '
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `nv_config`
-- ----------------------------
DROP TABLE IF EXISTS `nv_config`;
CREATE TABLE `nv_config` (
  `dict_entry` varchar(10) NOT NULL,
  `dict_code` varchar(10) NOT NULL,
  `dict_name` varchar(20) NOT NULL,
  `flag` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
