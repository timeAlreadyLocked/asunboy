-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.15 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 tenant_center 的数据库结构
CREATE DATABASE IF NOT EXISTS `tenant_center` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `tenant_center`;


-- 导出  表 tenant_center.tenant 结构
CREATE TABLE IF NOT EXISTS `tenant` (
  `id` bigint(20) unsigned NOT NULL COMMENT '租户ID。管理者的租户系统里对应的伙伴ID',
  `tenant_code` varchar(16) NOT NULL COMMENT '租户代码',
  `tenant_name` varchar(200) NOT NULL COMMENT '租户名称',
  `server_point_id` int(10) unsigned NOT NULL COMMENT '服务接入点ID',
  `tenant_schema` varchar(64) NOT NULL COMMENT 'DB schema',
  `tenant_schema_created` bit(1) NOT NULL DEFAULT b'0' COMMENT 'DB schema已创建？',
  `private_bucket_id` int(11) NOT NULL DEFAULT '0' COMMENT '私有存储空间 ID',
  `lang` varchar(8) NOT NULL DEFAULT 'zh-CN' COMMENT '默认语言',
  `enabled` bit(1) NOT NULL DEFAULT b'1' COMMENT '启用？',
  `service_end_time` date NOT NULL COMMENT '服务截止日期',
  `is_manager` bit(1) NOT NULL DEFAULT b'0' COMMENT '租户管理者',
  `max_user_count` int(11) NOT NULL DEFAULT '10' COMMENT '最大用户数',
  `max_oss_size` int(11) NOT NULL DEFAULT '1073741824' COMMENT '最大OSS存储空间。单位：字节',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_tenantCode` (`tenant_code`) USING BTREE,
  UNIQUE KEY `unique_tenantName` (`tenant_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='租户';

-- 正在导出表  tenant_center.tenant 的数据：~15 rows (大约)
/*!40000 ALTER TABLE `tenant` DISABLE KEYS */;
INSERT INTO `tenant` (`id`, `tenant_code`, `tenant_name`, `currency`, `multi_currency_supported`, `server_point_id`, `tenant_schema`, `tenant_schema_created`, `private_bucket_id`, `lang`, `enabled`, `service_end_time`, `is_manager`, `max_user_count`, `max_oss_size`, `created_on`, `created_by`, `modified_on`, `modified_by`) VALUES
	(1, 'fdafdasdfdfsdfas', 'xxxxx科技有限公司', 1, 'xxxxx', b'1', 21, 'zh-CN', b'1', '2019-06-01', b'1', 100, 999999);
/*!40000 ALTER TABLE `tenant` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
