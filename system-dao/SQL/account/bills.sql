/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-02-23 12:01:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payPerson` varchar(255) DEFAULT NULL,
  `shareWYM` int(255) DEFAULT NULL,
  `shareLRH` int(255) DEFAULT NULL,
  `shareCX` int(255) DEFAULT NULL,
  `shareZXW` int(255) DEFAULT NULL,
  `money` float(255,2) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
