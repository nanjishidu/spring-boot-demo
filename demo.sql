-- Adminer 4.3.1 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `address` text,
  `description` text,
  `role` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `t_user` (`id`, `name`, `username`, `password`, `phone`, `sex`, `age`, `create_time`, `address`, `description`, `role`, `status`) VALUES
(1,	'张三',	'admin',	'21232f297a57a5a743894a0e4a801fc3',	'18009260926',	1,	18,	'2017-11-23 16:44:20',	'济南市历下区文化西路44号',	'...',	0,	0),
(2,	'李四',	'admin2',	'21232f297a57a5a743894a0e4a801fc3',	'18009270927',	2,	18,	'2017-11-23 16:44:26',	'济南市历下区文化西路44号',	'...',	0,	0);
-- oracle
-- CREATE table t_user
-- (
--   ID             NUMBER NOT NULL,
--   NAME           VARCHAR2(100),
--   USERNAME       VARCHAR2(100),
--   PASSWORD       VARCHAR2(100),
--   PHONE          VARCHAR2(50),
--   SEX            NUMBER(1) DEFAULT 0 NOT NULL,
--   AGE            NUMBER(3) DEFAULT 0 NOT NULL,
--   CREATE_TIME    TIMESTAMP,
--   ADDRESS        VARCHAR2(255),
--   DESCRIPTION    VARCHAR2(255),
--   ROLE           NUMBER(1) DEFAULT 0  NOT NULL,
--   STATUS         NUMBER(1) DEFAULT 0  NOT NULL
-- );