/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-03-30 17:31:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accountx_paylog
-- ----------------------------
DROP TABLE IF EXISTS `accountx_paylog`;
CREATE TABLE `accountx_paylog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `record_id` int(11) DEFAULT NULL,
  `from_user` varchar(255) DEFAULT NULL,
  `to_user` varchar(255) DEFAULT NULL,
  `money` float(255,5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
