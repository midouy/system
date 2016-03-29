/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : system

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-03-29 17:03:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accountx_bill
-- ----------------------------
DROP TABLE IF EXISTS `accountx_bill`;
CREATE TABLE `accountx_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payer` varchar(255) DEFAULT NULL,
  `money` float(255,0) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
