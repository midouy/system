/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-03-30 17:31:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accountx_user
-- ----------------------------
DROP TABLE IF EXISTS `accountx_user`;
CREATE TABLE `accountx_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of accountx_user
-- ----------------------------
INSERT INTO `accountx_user` VALUES ('1', '王雁鸣', 'wym');
INSERT INTO `accountx_user` VALUES ('2', '刘偌含', 'lrh');
INSERT INTO `accountx_user` VALUES ('3', '陈茜', 'cx');
INSERT INTO `accountx_user` VALUES ('4', '张晓巍', 'zxw');
