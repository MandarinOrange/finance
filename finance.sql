/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : finance

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 03/01/2019 20:20:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `checkNum` varchar(20) NOT NULL,
  `userNum` varchar(20) NOT NULL,
  `productNum` varchar(20) NOT NULL,
  `bankAccount` varchar(20) NOT NULL,
  `checkState` int(2) NOT NULL,
  `contractNum` varchar(20) DEFAULT NULL,
  `isSignContract` tinyint(1) DEFAULT NULL,
  `year` int(2) NOT NULL,
  `amount` float(20,0) NOT NULL,
  `applyTime` varchar(20) NOT NULL,
  PRIMARY KEY (`checkNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank` (
  `bankNum` varchar(10) NOT NULL,
  `bankName` varchar(20) NOT NULL,
  `contact` varchar(20) NOT NULL,
  PRIMARY KEY (`bankNum`),
  KEY `bankNum` (`bankNum`,`bankName`,`contact`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerNum` varchar(10) NOT NULL,
  `managerName` varchar(20) NOT NULL,
  `managerPwd` varchar(20) NOT NULL,
  `managerRight` varchar(2) NOT NULL,
  `telephoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`managerNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `productNum` varchar(20) NOT NULL,
  `productName` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `intrate` float(10,0) NOT NULL,
  `bankNum` varchar(20) NOT NULL,
  `productDescription` text,
  `pictureAddress` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `transactionNum` varchar(20) NOT NULL,
  `payer` varchar(20) NOT NULL,
  `payee` varchar(20) NOT NULL,
  `transactionTime` float(20,0) NOT NULL,
  `transactionAmount` float(20,0) NOT NULL,
  `note` text,
  PRIMARY KEY (`transactionNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for usageData
-- ----------------------------
DROP TABLE IF EXISTS `usageData`;
CREATE TABLE `usageData` (
  `checkNum` varchar(20) NOT NULL,
  `productNum` varchar(20) NOT NULL,
  `userNum` varchar(20) NOT NULL,
  `bankAccount` varchar(20) NOT NULL,
  `bankNum` varchar(20) NOT NULL,
  `year` int(2) NOT NULL,
  `amount` float(20,0) NOT NULL,
  `startTime` varchar(20) NOT NULL,
  PRIMARY KEY (`checkNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userNum` varchar(10) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `userPwd` varchar(20) NOT NULL,
  `userRight` varchar(2) NOT NULL,
  `tureName` varchar(20) DEFAULT NULL,
  `idNum` varchar(18) DEFAULT NULL,
  `telephoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `isIdentify` tinyint(1) DEFAULT NULL,
  `registerTime` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for userBankIdentify
-- ----------------------------
DROP TABLE IF EXISTS `userBankIdentify`;
CREATE TABLE `userBankIdentify` (
  `userName` varchar(20) NOT NULL,
  `bankAccount` varchar(20) NOT NULL,
  `bankAccountIdentify` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userName`,`bankAccount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
