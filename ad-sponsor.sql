drop DATABASE AdCloud_ad_data;
CREATE DATABASE AdCloud_ad_data character set utf8;

use AdCloud_ad_data;


CREATE TABLE `ad_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key, auto incremented',
  `username` varchar(128) NOT NULL DEFAULT '' COMMENT 'user name',
  `token` varchar(256) NOT NULL DEFAULT '' COMMENT 'user token',
  `user_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'user status',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='user info table';



CREATE TABLE `ad_plan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key, auto incremented',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'user id belongs to',
  `plan_name` varchar(48) NOT NULL COMMENT 'plan name',
  `plan_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'status of the plan',
  `start_date` datetime NOT NULL COMMENT 'start time',
  `end_date` datetime NOT NULL COMMENT 'end time',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='plan table';


CREATE TABLE `ad_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key, auto incremented',
  `plan_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'linked to plan table id',
  `unit_name` varchar(48) NOT NULL COMMENT 'unit name',
  `unit_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'status',
  `position_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'position status of the ad, e.g., at front, at middle...',
  `budget` bigint(20) NOT NULL COMMENT 'budget',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='unit table';


CREATE TABLE `ad_creative` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'primary key, auto incremented',
  `name` varchar(48) NOT NULL COMMENT 'creative name',
  `type` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'material type(pic, video)',
  `material_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'type of the material(pic: bmp, jpg..)',
  `height` int(10) NOT NULL DEFAULT '0' COMMENT 'height',
  `width` int(10) NOT NULL DEFAULT '0' COMMENT 'width',
  `size` bigint(20) NOT NULL DEFAULT '0' COMMENT 'size of the material / KB',
  `duration` int(10) NOT NULL DEFAULT '0' COMMENT 'duration / not 0',
  `audit_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'status',
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'user belongs to',
  `url` varchar(256) NOT NULL COMMENT 'material url',
  `create_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'create time',
  `update_time` datetime NOT NULL DEFAULT '1970-01-01 00:00:00' COMMENT 'update time',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='creative table';


CREATE TABLE `creative_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `creative_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'creative id',
  `unit_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'unit id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='linking table';


CREATE TABLE `ad_unit_keyword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_id` int(11) NOT NULL COMMENT 'unit id',
  `keyword` varchar(30) NOT NULL COMMENT 'keywords',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='Feature';


CREATE TABLE `ad_unit_it` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_id` int(11) NOT NULL COMMENT 'unit id',
  `it_tag` varchar(30) NOT NULL COMMENT 'label of interests',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='unit Feature';


CREATE TABLE `ad_unit_district` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit_id` int(11) NOT NULL COMMENT 'unit id',
  `province` varchar(30) NOT NULL COMMENT 'province',
  `city` varchar(30) NOT NULL COMMENT 'city',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='area Feature';
