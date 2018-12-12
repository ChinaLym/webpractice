/*
SQLyog v10.2 
MySQL - 5.7.20 : Database - e_declare
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`e_declare` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `e_declare`;

/*Table structure for table `tb_activity` */

DROP TABLE IF EXISTS `tb_activity`;

CREATE TABLE `tb_activity` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `publish_man` int(11) unsigned DEFAULT NULL COMMENT '发布人',
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '活动标题',
  `content` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动内容',
  `level` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动级别',
  `update_time` datetime DEFAULT NULL COMMENT '修改/发布时间',
  `start_time` datetime DEFAULT NULL COMMENT '创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `text` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_activity` */

/*Table structure for table `tb_authority` */

DROP TABLE IF EXISTS `tb_authority`;

CREATE TABLE `tb_authority` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) NOT NULL COMMENT '父节点id',
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `url` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url地址',
  `describe` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限描述',
  `status` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_authority` */

/*Table structure for table `tb_message` */

DROP TABLE IF EXISTS `tb_message`;

CREATE TABLE `tb_message` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(30) COLLATE utf8_unicode_ci DEFAULT 'empty' COMMENT '消息标题',
  `sender` varchar(30) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'system' COMMENT '发起人',
  `idx_receiver` int(11) unsigned NOT NULL COMMENT '接收者,user_id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '消息内容',
  `is_read` tinyint(3) unsigned DEFAULT '0' COMMENT '0:未读，else已读',
  `is_delete` tinyint(3) unsigned DEFAULT '0' COMMENT '0:未删除，1已删除',
  PRIMARY KEY (`pk_id`),
  KEY `idx_receiver` (`idx_receiver`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_message` */

/*Table structure for table `tb_meterial` */

DROP TABLE IF EXISTS `tb_meterial`;

CREATE TABLE `tb_meterial` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `idx_project_id` int(11) unsigned NOT NULL COMMENT '所属项目',
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '材料名称',
  `text` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `url` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提交地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `change_time` datetime DEFAULT NULL COMMENT '修改时间',
  `end_time` datetime DEFAULT NULL COMMENT '截止时间',
  `is_commit` tinyint(3) unsigned DEFAULT '0' COMMENT '是否提交',
  PRIMARY KEY (`pk_id`),
  KEY `idx_project_id` (`idx_project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_meterial` */

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `idx_activity_id` int(11) unsigned NOT NULL COMMENT '所报活动id',
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名称',
  `idx_director` int(11) unsigned NOT NULL COMMENT '负责人',
  `level` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属级别',
  `domain` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属领域or专业',
  `promise` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '立项承诺',
  `score` int(11) unsigned DEFAULT NULL COMMENT '专家打分',
  `remarks` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专家评语',
  `text` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `status` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '目前状态:初审通过 | 项评审中 | 已立项 | 不立项 | 中期检查通过 | 中期检查待整改 | 已结题 | 结题验收待整改',
  PRIMARY KEY (`pk_id`),
  KEY `activity_id` (`idx_activity_id`),
  KEY `idx_director` (`idx_director`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_project` */

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `description` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `status` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_role` */

/*Table structure for table `tb_role_authority` */

DROP TABLE IF EXISTS `tb_role_authority`;

CREATE TABLE `tb_role_authority` (
  `pk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL,
  `anthority_id` int(11) NOT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_role_authority` */

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uk_account` varchar(30) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户姓名',
  `sex` varchar(4) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户性别',
  `idx_phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户电话',
  `department` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属部门',
  `role_id` int(11) DEFAULT NULL COMMENT '所属角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  `status` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户状态',
  `text` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `uk_account` (`uk_account`),
  KEY `idx_phone` (`idx_phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tb_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
