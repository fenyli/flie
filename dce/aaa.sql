/*
Navicat MySQL Data Transfer

Source Server         : shixun
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : aaa

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2023-01-02 23:01:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_caigoumingxi
-- ----------------------------
DROP TABLE IF EXISTS `t_caigoumingxi`;
CREATE TABLE `t_caigoumingxi` (
  `id` char(10) CHARACTER SET utf8mb4 NOT NULL,
  `rukushijian` datetime DEFAULT NULL,
  `zongjine` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `fuzeren` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `beizhu` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `mingxi` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_caigoumingxi
-- ----------------------------
INSERT INTO `t_caigoumingxi` VALUES ('1', '2022-09-08 00:00:00', '100', '张铭', 'NULL', 'NULL');
INSERT INTO `t_caigoumingxi` VALUES ('3', '2021-06-09 00:00:00', '200', 'admin', '没有', null);
INSERT INTO `t_caigoumingxi` VALUES ('7', '2022-03-04 00:00:00', '50', 'admin', 'null', null);

-- ----------------------------
-- Table structure for t_catelog
-- ----------------------------
DROP TABLE IF EXISTS `t_catelog`;
CREATE TABLE `t_catelog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_catelog
-- ----------------------------
INSERT INTO `t_catelog` VALUES ('6', '抗生素类药品', '1');
INSERT INTO `t_catelog` VALUES ('7', '心脑血管药品', '1');
INSERT INTO `t_catelog` VALUES ('8', '消化系统药品', '1');
INSERT INTO `t_catelog` VALUES ('9', '呼吸系统药品', '1');
INSERT INTO `t_catelog` VALUES ('10', '抗风湿类药品', '1');
INSERT INTO `t_catelog` VALUES ('11', '皮肤科药品', '1');

-- ----------------------------
-- Table structure for t_chuku
-- ----------------------------
DROP TABLE IF EXISTS `t_chuku`;
CREATE TABLE `t_chuku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `danjuhao` varchar(50) DEFAULT NULL,
  `shijian` date DEFAULT NULL,
  `zongjiage` double(10,2) DEFAULT NULL,
  `jingshouren` varchar(50) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_chuku
-- ----------------------------
INSERT INTO `t_chuku` VALUES ('9', '20201103', '2020-12-03', '500.00', 'zhangsan', '销售了500块', '1');

-- ----------------------------
-- Table structure for t_chukumingxi
-- ----------------------------
DROP TABLE IF EXISTS `t_chukumingxi`;
CREATE TABLE `t_chukumingxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chuku_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_chukumingxi
-- ----------------------------
INSERT INTO `t_chukumingxi` VALUES ('12', '9', '15', '50', '价值500');

-- ----------------------------
-- Table structure for t_gongyingshang
-- ----------------------------
DROP TABLE IF EXISTS `t_gongyingshang`;
CREATE TABLE `t_gongyingshang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) DEFAULT NULL,
  `dizhi` varchar(50) DEFAULT NULL,
  `lianxiren` varchar(50) DEFAULT NULL,
  `dianhua` varchar(50) DEFAULT NULL,
  `youbian` varchar(50) DEFAULT NULL,
  `chuanzhen` varchar(50) DEFAULT NULL,
  `youxiang` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '状态码：0表示删除、1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_gongyingshang
-- ----------------------------
INSERT INTO `t_gongyingshang` VALUES ('9', '新华制药科技', '北京市新二路21号', '张明亮', '15166862157', '264002', '010-2541211', 'zhangmingliang@126.com', '1');
INSERT INTO `t_gongyingshang` VALUES ('10', '荣昌制药', '北京长江路21号', '陈明', '15166862154', '265214', '010-11412541', 'chenming@126.com', '1');
INSERT INTO `t_gongyingshang` VALUES ('11', '成都华西', '成都市武侯区', 'yaya', '18088252653', '45454545', '45545-45454', '2955655656@qq.com', '0');
INSERT INTO `t_gongyingshang` VALUES ('12', '11 ', '22', '33', '44', '55', '66', '77', '1');

-- ----------------------------
-- Table structure for t_goods
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catelog_id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `gys_id` int(11) DEFAULT NULL,
  `danwei` varchar(50) DEFAULT NULL,
  `baozhiqi` varchar(50) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('15', '6', '三九感冒颗粒', '9', '包', '24个月', '无', '0');
INSERT INTO `t_goods` VALUES ('16', '6', '四季抗病毒', '9', '盒', '24个月', '无', '1');
INSERT INTO `t_goods` VALUES ('17', '6', '头孢颗粒', '9', '包', '24个月', '', '0');
INSERT INTO `t_goods` VALUES ('19', '10', '风湿药', '10', '盒', '2年', '疫情', '1');
INSERT INTO `t_goods` VALUES ('20', '10', '正红花油', '10', '成都华西', '21', '', '1');
INSERT INTO `t_goods` VALUES ('28', '3', 'YaYa Zou', '5', '石柱中学', '三年', 'null', '0');
INSERT INTO `t_goods` VALUES ('29', '5', 'Zou', '6', 'sz', '两年', '没有', '1');
INSERT INTO `t_goods` VALUES ('30', '3', '藿香正气液', '7', '米市院', '10天', '用于头晕', '1');
INSERT INTO `t_goods` VALUES ('31', '2', '美林', '8', '重庆沙坪坝', '1年', '小孩退烧', '1');

-- ----------------------------
-- Table structure for t_ruku
-- ----------------------------
DROP TABLE IF EXISTS `t_ruku`;
CREATE TABLE `t_ruku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `danjuhao` varchar(50) DEFAULT NULL,
  `shijian` date DEFAULT NULL,
  `zongjiage` double(10,2) DEFAULT NULL,
  `jingshouren` varchar(50) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_ruku
-- ----------------------------
INSERT INTO `t_ruku` VALUES ('16', '20201102', '2020-12-02', '1000.00', '张铭', '采购第一批', '1');

-- ----------------------------
-- Table structure for t_rukumingxi
-- ----------------------------
DROP TABLE IF EXISTS `t_rukumingxi`;
CREATE TABLE `t_rukumingxi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ruku_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `shuliang` int(11) DEFAULT NULL,
  `beizhu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_rukumingxi
-- ----------------------------
INSERT INTO `t_rukumingxi` VALUES ('20', '16', '15', '50', '价值500');
INSERT INTO `t_rukumingxi` VALUES ('21', '16', '16', '50', '价值500');

-- ----------------------------
-- Table structure for t_sell
-- ----------------------------
DROP TABLE IF EXISTS `t_sell`;
CREATE TABLE `t_sell` (
  `id` char(10) CHARACTER SET utf8mb4 NOT NULL,
  `datetime` datetime DEFAULT NULL,
  `price` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `yuangong` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `remark` varchar(200) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_sell
-- ----------------------------
INSERT INTO `t_sell` VALUES ('11', '2022-01-01 00:00:00', '200', 'Jack', 'null');
INSERT INTO `t_sell` VALUES ('12', null, '12312', 'Jack', '23');
INSERT INTO `t_sell` VALUES ('5', '2021-09-21 00:00:00', '200', 'Jack', '没有');
INSERT INTO `t_sell` VALUES ('第五十单', '2022-09-30 00:00:00', '100', 'Jack', '没有');

-- ----------------------------
-- Table structure for t_staff
-- ----------------------------
DROP TABLE IF EXISTS `t_staff`;
CREATE TABLE `t_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `zhiwei` varchar(50) DEFAULT NULL,
  `quanxian` int(11) DEFAULT NULL,
  `status` int(50) DEFAULT '1',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_staff
-- ----------------------------
INSERT INTO `t_staff` VALUES ('7', '张铭', '男', '21', '15166862154', '北京路21号', '员工', '0', '1', '3');
INSERT INTO `t_staff` VALUES ('8', 'zhangsan', '女', '32', '15166862156', '北三路25号', '经理', '0', '1', '2');
INSERT INTO `t_staff` VALUES ('18', 'John', '男', '32', '15725252525', 'chengdu', 'java', null, '1', '17');
INSERT INTO `t_staff` VALUES ('19', 'ZouY', '女', '21', '19823723207', '重庆石柱', '学生', null, '0', null);
INSERT INTO `t_staff` VALUES ('20', 'XF', '男', '21', '111111111', '冷水', '学生', null, '1', null);

-- ----------------------------
-- Table structure for t_supplier
-- ----------------------------
DROP TABLE IF EXISTS `t_supplier`;
CREATE TABLE `t_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `link` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `code` varchar(255) DEFAULT NULL COMMENT '邮编',
  `fax` varchar(255) DEFAULT NULL COMMENT '传真',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `status` int(11) DEFAULT NULL COMMENT '状态码：0表示删除、1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_supplier
-- ----------------------------
INSERT INTO `t_supplier` VALUES ('9', '新华制药科技', '北京市新二路21号', '张明亮', '15166862157', '264002', '010-2541211', 'zhangmingliang@126.com', '1');
INSERT INTO `t_supplier` VALUES ('10', '荣昌制药', '北京长江路21号', '陈明', '15166862154', '265214', '010-11412541', 'chenming@126.com', '1');
INSERT INTO `t_supplier` VALUES ('11', '成都华西', '成都市武侯区', 'yaya', '18088252653', '45454545', '45545-45454', '2955655656@qq.com', '0');
INSERT INTO `t_supplier` VALUES ('13', '11', '22', '33', '44', '55', '66', '77', '0');
INSERT INTO `t_supplier` VALUES ('15', '第二师范学院', '重庆石柱', 'zy', '320142', '1234', '788', '2630423668@qq.com', '1');
INSERT INTO `t_supplier` VALUES ('16', '南宾中学', '火车站', 'Zou', '6666666', '999', '333', '222', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `status` int(1) DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'E10ADC3949BA59ABBE56E057F20F883E', '1');
INSERT INTO `t_user` VALUES ('2', 'zhangsan', 'E10ADC3949BA59ABBE56E057F20F883E', '1');
INSERT INTO `t_user` VALUES ('3', '张铭', 'E10ADC3949BA59ABBE56E057F20F883E', '1');
INSERT INTO `t_user` VALUES ('17', 'John', 'E10ADC3949BA59ABBE56E057F20F883E', '1');
