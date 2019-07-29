-- --------------------------------------------------------
-- 主机:                           192.168.10.176
-- 服务器版本:                        Microsoft SQL Server 2012 - 11.0.2100.60
-- 服务器操作系统:                      Windows NT 6.1 <X64> (Build 7601: Service Pack 1)
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 assetnew 的数据库结构
CREATE DATABASE IF NOT EXISTS "assetnew";
USE "assetnew";


-- 导出  表 assetnew.abase 结构
CREATE TABLE IF NOT EXISTS "abase" (
	"rdn" INT(10,0) NOT NULL,
	"code" VARCHAR(10) NULL DEFAULT NULL,
	"ct" VARCHAR(3) NULL DEFAULT NULL,
	"remark" VARCHAR(50) NULL DEFAULT NULL,
	"ctmark" VARCHAR(50) NULL DEFAULT NULL,
	"cflag" CHAR(1) NULL DEFAULT NULL
);

-- 正在导出表  assetnew.abase 的数据：-1 rows
/*!40000 ALTER TABLE "abase" DISABLE KEYS */;
INSERT INTO "abase" ("rdn", "code", "ct", "remark", "ctmark", "cflag") VALUES
	(1, '1', 'A1', '公司', NULL, NULL),
	(2, '2', 'A1', '厂家', NULL, NULL),
	(3, 'B', 'A1', '公司 , 厂家', NULL, NULL),
	(4, '0', 'A2', '不计成本', NULL, NULL),
	(5, '1', 'A2', '计成本', NULL, NULL),
	(6, '0', 'A3', '其它', '成本核算方式  rtntype', NULL),
	(7, '1', 'A3', '一次性', NULL, NULL),
	(8, '2', 'A3', '按时分摊', NULL, NULL),
	(9, '3', 'A3', '按次分摊', NULL, NULL),
	(10, '11', 'B1', '公司营业执照', NULL, '1'),
	(11, '12', 'B1', '经营许可证', NULL, '1'),
	(12, '13', 'B1', '生产许可证', NULL, '1'),
	(13, '14', 'B1', '注册证', NULL, '0'),
	(14, '15', 'B1', '卫生许可证', NULL, '1'),
	(15, '21', 'B1', '销售员身份证', NULL, '1'),
	(16, '22', 'B1', '销售员电话', NULL, '1'),
	(17, '23', 'B1', '医疗器械经营许可证', NULL, '1'),
	(18, '24', 'B1', '第二类医疗器械经营备案凭证', NULL, '1'),
	(19, '25', 'B1', '医疗器械生产许可证(含产品登记表)', NULL, '1'),
	(20, '26', 'B1', '第一类医疗器械生产备案证（含产品登记表）', NULL, '1'),
	(21, '27', 'B1', '消毒产品生产企业卫生许可证', NULL, '1'),
	(22, '28', 'B1', '医疗器械注册证（含附页）', NULL, '0'),
	(23, '29', 'B1', '第一类医疗器械备案凭证（含附页）', NULL, '0'),
	(24, '30', 'B1', '消毒产品卫生安全评价报告及备案凭证', NULL, '0');
/*!40000 ALTER TABLE "abase" ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
