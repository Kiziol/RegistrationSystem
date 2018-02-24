/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : registersystem

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-26 17:28:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('123', '123');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL COMMENT '学院名称',
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES ('1', '农业与食品科学学院');
INSERT INTO `college` VALUES ('2', '环境与资源学院');
INSERT INTO `college` VALUES ('3', '风景园林与建筑学院、旅游与健康学院');
INSERT INTO `college` VALUES ('4', '动物科技学院');
INSERT INTO `college` VALUES ('5', '法政学院');
INSERT INTO `college` VALUES ('6', '信息工程学院');
INSERT INTO `college` VALUES ('7', '理学院');
INSERT INTO `college` VALUES ('8', '国际教育学院');
INSERT INTO `college` VALUES ('9', '林业与生物技术学院');
INSERT INTO `college` VALUES ('10', '工程学院');
INSERT INTO `college` VALUES ('11', '经济管理学院');
INSERT INTO `college` VALUES ('12', '马克思主义学院');
INSERT INTO `college` VALUES ('13', '艺术设计学院、人文·茶文华学院');
INSERT INTO `college` VALUES ('14', '外国学院');
INSERT INTO `college` VALUES ('15', '集贤学院');
INSERT INTO `college` VALUES ('16', '继续教育学院');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(255) NOT NULL COMMENT '学生姓名',
  `snumber` varchar(255) NOT NULL COMMENT '学号',
  `cid` int(11) NOT NULL COMMENT '所属学院',
  `tid` int(11) NOT NULL COMMENT '队伍编号',
  `telephone` varchar(255) NOT NULL COMMENT '手机号',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `state` int(11) DEFAULT '0' COMMENT '审核状态',
  PRIMARY KEY (`sid`),
  KEY `学院编号` (`cid`),
  KEY `队伍编号` (`tid`),
  CONSTRAINT `学院编号` FOREIGN KEY (`cid`) REFERENCES `college` (`cid`),
  CONSTRAINT `队伍编号` FOREIGN KEY (`tid`) REFERENCES `team` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `sjid` int(11) NOT NULL AUTO_INCREMENT COMMENT '题目编号',
  `sjname` varchar(255) NOT NULL COMMENT '题目名称',
  PRIMARY KEY (`sjid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tcid` int(11) NOT NULL,
  `tname` varchar(255) NOT NULL COMMENT '老师姓名',
  `cid` int(11) NOT NULL COMMENT '所在学院',
  `tid` int(11) NOT NULL COMMENT '队伍编号',
  `telephone` varchar(255) NOT NULL COMMENT '手机号码',
  `email` varchar(255) NOT NULL COMMENT '邮箱',
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`tcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `teamname` varchar(255) NOT NULL COMMENT '队伍名称',
  `sjid` int(11) DEFAULT NULL COMMENT '题目编号',
  PRIMARY KEY (`tid`),
  KEY `题目编号` (`sjid`),
  CONSTRAINT `题目编号` FOREIGN KEY (`sjid`) REFERENCES `subject` (`sjid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('15', '1', '1', '1', null);
INSERT INTO `team` VALUES ('16', '2', '2', '2', null);
INSERT INTO `team` VALUES ('17', '3', '3', '3', null);
INSERT INTO `team` VALUES ('18', '4', '4', '4', null);
INSERT INTO `team` VALUES ('19', '5', '5', '5', null);
