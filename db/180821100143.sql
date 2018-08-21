/*
MySQL Backup
Source Server Version: 5.7.23
Source Database: mytest
Date: 2018/8/21 10:01:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `tree_folder`
-- ----------------------------
DROP TABLE IF EXISTS `tree_folder`;
CREATE TABLE `tree_folder` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `folder_name` varchar(255) DEFAULT NULL COMMENT '文件夹名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `tree_relation`
-- ----------------------------
DROP TABLE IF EXISTS `tree_relation`;
CREATE TABLE `tree_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `PARENT_ID` int(11) DEFAULT NULL,
  `CHILD_ID` int(11) DEFAULT NULL,
  `depth` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `parentid2folderid` (`PARENT_ID`),
  KEY `childid2folderid` (`CHILD_ID`),
  CONSTRAINT `childid2folderid` FOREIGN KEY (`CHILD_ID`) REFERENCES `tree_folder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `parentid2folderid` FOREIGN KEY (`PARENT_ID`) REFERENCES `tree_folder` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=222 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `tree_folder` VALUES ('15','root'), ('26','a'), ('27','b'), ('28','c'), ('29','d'), ('30','g'), ('31','e'), ('32','f'), ('33','h'), ('34','i');
INSERT INTO `tree_relation` VALUES ('145','15','15','0'), ('179','15','26','1'), ('180','26','26','0'), ('182','15','27','1'), ('183','27','27','0'), ('185','15','28','1'), ('186','28','28','0'), ('188','15','29','2'), ('189','26','29','1'), ('190','29','29','0'), ('191','15','30','2'), ('192','27','30','1'), ('193','30','30','0'), ('194','15','31','3'), ('195','26','31','2'), ('196','29','31','1'), ('197','31','31','0'), ('201','15','32','3'), ('202','26','32','2'), ('203','29','32','1'), ('204','32','32','0'), ('208','15','33','4'), ('209','26','33','3'), ('210','29','33','2'), ('211','32','33','1'), ('212','33','33','0'), ('215','15','34','4'), ('216','26','34','3'), ('217','29','34','2'), ('218','32','34','1'), ('219','34','34','0');
