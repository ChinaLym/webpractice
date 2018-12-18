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
CREATE DATABASE /*!32312 IF NOT EXISTS*/`e_declare` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `e_declare`;

/*Table structure for table `tb_activity` */

DROP TABLE IF EXISTS `tb_activity`;

CREATE TABLE `tb_activity` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sponsor` int(11) unsigned DEFAULT NULL COMMENT '发布人_user表主键',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '活动标题',
  `content` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动内容',
  `level` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '活动级别：[校级一类，校级二类]',
  `update_time` datetime DEFAULT NULL COMMENT '修改/发布时间',
  `start_time` datetime DEFAULT NULL COMMENT '创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `text` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_activity` */

insert  into `tb_activity`(`pk_id`,`sponsor`,`title`,`content`,`level`,`update_time`,`start_time`,`end_time`,`text`) values (1,2,'第一届大学生JavaWeb大赛','报名者须...','一等','2018-12-15 21:03:39','2018-12-15 21:03:54','2019-01-16 21:03:58','强烈建议大家参与');

/*Table structure for table `tb_authority` */

DROP TABLE IF EXISTS `tb_authority`;

CREATE TABLE `tb_authority` (
  `pk_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) NOT NULL COMMENT '父节点id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限名称',
  `url` varchar(250) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'url地址',
  `describe` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '权限描述',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'NORMAL' COMMENT '状态：[正常，禁用]',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `tb_authority` */

insert  into `tb_authority`(`pk_id`,`parent_id`,`name`,`url`,`describe`,`status`) values (1,-1,'根目录','/','根节点','NORMAL'),(2,1,'系统设置',NULL,'系统稳定有关的设置','NORMAL'),(3,2,'角色权限管理',NULL,'管理所有角色权限的能力','NORMAL'),(4,2,'菜单管理',NULL,'管理菜单','NORMAL'),(5,2,'角色管理',NULL,'改变其他用户的角色','NORMAL'),(6,1,'用户管理',NULL,'与用户相关的管理','NORMAL'),(7,6,'用户信息管理',NULL,'修改其他用户的信息','NORMAL'),(8,6,'用户角色分配',NULL,'修改其他用户的角色','NORMAL'),(9,6,'密码重置',NULL,'重置其他用户密码','NORMAL');

/*Table structure for table `tb_message` */

DROP TABLE IF EXISTS `tb_message`;

CREATE TABLE `tb_message` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'empty' COMMENT '消息标题',
  `sender` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'system' COMMENT '发起人',
  `idx_receiver` int(11) unsigned NOT NULL COMMENT '接收者,user_id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '消息内容',
  `is_read` tinyint(1) DEFAULT '0' COMMENT '0:未读，else已读',
  `is_delete` tinyint(1) DEFAULT '0' COMMENT '0:未删除，1已删除',
  PRIMARY KEY (`pk_id`),
  KEY `idx_receiver` (`idx_receiver`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `tb_message` */

insert  into `tb_message`(`pk_id`,`title`,`sender`,`idx_receiver`,`create_time`,`content`,`is_read`,`is_delete`) values (1,'消息标题','system',1,'2018-12-15 19:12:17','这是一条测试消息',0,0),(2,'一条消息','system',1,'2018-12-15 19:13:12','第二条测试消息',0,0);

/*Table structure for table `tb_meterial` */

DROP TABLE IF EXISTS `tb_meterial`;

CREATE TABLE `tb_meterial` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `idx_project_id` int(11) unsigned NOT NULL COMMENT '所属项目',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '材料名称',
  `text` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '提交地址',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `change_time` datetime DEFAULT NULL COMMENT '修改时间',
  `end_time` datetime DEFAULT NULL COMMENT '最晚提交截止时间',
  `is_commit` tinyint(1) DEFAULT '0' COMMENT '是否提交',
  PRIMARY KEY (`pk_id`),
  KEY `idx_project_id` (`idx_project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_meterial` */

insert  into `tb_meterial`(`pk_id`,`idx_project_id`,`name`,`text`,`url`,`create_time`,`change_time`,`end_time`,`is_commit`) values (1,1,'方舟反应炉','也称作常温核反应或者冷核聚变反应堆','D:/test/ArcReactor.jpg','2018-12-16 14:42:07','2018-12-16 14:42:15','2019-01-01 14:42:28',0);

/*Table structure for table `tb_project` */

DROP TABLE IF EXISTS `tb_project`;

CREATE TABLE `tb_project` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `idx_activity_id` int(11) unsigned NOT NULL COMMENT '所报活动id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '项目名称',
  `idx_director` int(11) unsigned NOT NULL COMMENT '负责人',
  `level` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属级别',
  `domain` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属领域or专业',
  `promise` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '立项承诺',
  `score` int(11) unsigned DEFAULT NULL COMMENT '专家打分',
  `remarks` varchar(500) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '专家评语',
  `text` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'FIRST_TRIAL_PENDING' COMMENT '目前状态：[待初审，初审通过，初审不通过，立项评审中，已立项，不立项，待中期检查，中期检查通过，中期检查待整改，待结题，已结题，结题验收待整改]',
  PRIMARY KEY (`pk_id`),
  KEY `activity_id` (`idx_activity_id`),
  KEY `idx_director` (`idx_director`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tb_project` */

insert  into `tb_project`(`pk_id`,`idx_activity_id`,`name`,`idx_director`,`level`,`domain`,`promise`,`score`,`remarks`,`text`,`status`) values (1,1,'钢铁侠的铠甲研发',2,'校级一类','领域','立项承诺',0,'','备注','FIRST_TRIAL_PENDING');

/*Table structure for table `tb_role` */

DROP TABLE IF EXISTS `tb_role`;

CREATE TABLE `tb_role` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '角色名称',
  `description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '描述',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'NORMAL' COMMENT '状态：[正常，禁用]',
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role` */

insert  into `tb_role`(`pk_id`,`name`,`description`,`status`) values (1,'ROOT','权力至高无上','NORMAL'),(2,'行政管理员','总想发起项目','NORMAL'),(3,'专家','爱搞研究','NORMAL'),(4,'教职工','喜欢做项目','NORMAL'),(5,'职能部门员工','吃瓜','NORMAL');

/*Table structure for table `tb_role_authority` */

DROP TABLE IF EXISTS `tb_role_authority`;

CREATE TABLE `tb_role_authority` (
  `pk_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL,
  `anthority_id` int(11) NOT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tb_role_authority` */

insert  into `tb_role_authority`(`pk_id`,`role_id`,`anthority_id`) values (1,1,2),(2,1,3),(3,1,4),(4,1,5),(5,1,6),(6,1,7),(7,1,8),(8,1,9);

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `pk_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uk_account` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户账号',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '000000' COMMENT '用户密码',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '用户' COMMENT '用户姓名',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT '保密' COMMENT '用户性别:[保密，男，女]',
  `idx_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '用户电话',
  `department` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '所属部门',
  `role_id` int(11) DEFAULT NULL COMMENT '所属角色',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '最近更新时间',
  `status` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT 'NORMAL' COMMENT '用户状态：[正常，异常，冻结，销户]',
  `text` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pk_id`),
  UNIQUE KEY `uk_account` (`uk_account`),
  KEY `idx_phone` (`idx_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`pk_id`,`uk_account`,`password`,`name`,`sex`,`idx_phone`,`department`,`role_id`,`create_time`,`update_time`,`status`,`text`) values (1,'1111111111111','123456','ROOT','男','11111111111','部门',1,'2018-12-15 18:56:46','2018-12-15 18:56:51','NORMAL','至高无上的ROOT'),(2,'2015000000001','000000','张三','男','15888888888','总指挥部',2,'2018-12-15 19:15:56','2018-12-15 19:15:58','测试','就爱管项目');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
