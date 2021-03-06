/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : shetai

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2017-12-22 16:01:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `aid` varchar(50) NOT NULL COMMENT '用户ID',
  `uname` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `gender` int(1) DEFAULT NULL COMMENT '用户性别（0代表男，1代表女）',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `medical_history` varchar(100) DEFAULT NULL COMMENT '病史',
  `symptom` varchar(100) DEFAULT NULL COMMENT '最近症状',
  `type` int(1) DEFAULT NULL COMMENT '用户类型（0表示用户，1表示医生）',
  `account` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL COMMENT '用户表',
  `state` int(1) DEFAULT NULL COMMENT '申请状态（0表示未审核，1表示审核通过，2表示审核未通过）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `mid` varchar(50) NOT NULL COMMENT '消息id',
  `sender_id` varchar(50) DEFAULT NULL COMMENT '发送用户id',
  `receive_id` varchar(50) DEFAULT NULL COMMENT '接收用户id',
  `pid` varchar(50) DEFAULT NULL COMMENT '照片id',
  `content` varchar(100) DEFAULT NULL COMMENT '消息内容',
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '消息发送时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `nid` varchar(50) NOT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `uid` varchar(50) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for photo
-- ----------------------------
DROP TABLE IF EXISTS `photo`;
CREATE TABLE `photo` (
  `pid` varchar(50) NOT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `did` varchar(50) DEFAULT NULL COMMENT '医生id',
  `tid` varchar(50) DEFAULT NULL COMMENT '照片对应症状类型id（刚上传时为空，由医生判定类别后添加）',
  `position` varchar(100) DEFAULT NULL COMMENT '照片地址',
  `upload_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上传日期',
  `time` int(11) DEFAULT NULL COMMENT '拍摄时间段（0-早，1-中，2-晚）'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for symptom_type
-- ----------------------------
DROP TABLE IF EXISTS `symptom_type`;
CREATE TABLE `symptom_type` (
  `tid` varchar(50) NOT NULL COMMENT '分类id',
  `uper_id` varchar(50) DEFAULT NULL COMMENT '母分类id',
  `tname` varchar(50) DEFAULT NULL COMMENT '分类名称',
  `description` varchar(255) DEFAULT NULL COMMENT '分类详细描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` varchar(50) NOT NULL COMMENT '用户ID',
  `uname` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `gender` int(1) DEFAULT NULL COMMENT '用户性别（0代表男，1代表女）',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `medical_history` varchar(100) DEFAULT NULL COMMENT '病史',
  `symptom` varchar(100) DEFAULT NULL COMMENT '最近症状',
  `type` int(1) DEFAULT NULL COMMENT '用户类型（0表示用户，1表示医生）',
  `account` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL COMMENT '用户表'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
