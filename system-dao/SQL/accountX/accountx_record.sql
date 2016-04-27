/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-03-30 17:32:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accountx_record
-- ----------------------------
DROP TABLE IF EXISTS `accountx_record`;
CREATE TABLE `accountx_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` float(255,3) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
