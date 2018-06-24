drop database if exists actual_combat;
create database actual_combat default character set utf8 collate utf8_general_ci;
use actual_combat;

drop table if exists ac_user;
create table ac_user(
	id bigint(20) unsigned not null comment '用户ID',
	nickname varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci not null comment '用户网名',
	name varchar(64) comment '用户真实姓名',
	age tinyint unsigned comment '用户真实年龄',
	sex bit comment '用户性别',
	type_id tinyint not null comment '用户类型。管理员自定义类型,不同类型的用户权限不一样',
	login_pwd varchar(128) not null comment '用户登录密码',
	pwd_fail_times tinyint  not null default '0' comment '密码登录连续失败次数,登录成功，清除该值',
	status enum('created','enabled','locked','deleted') not null comment '用户的状态。created(创建的),enabled(启动的),locked(被锁的),deleted(已删除的)',
	locked_on datetime default null comment '用户被锁时间',
	last_login_on datetime default null comment '上一次登录成功时间',
	created_on datetime not null default current_timestamp comment '创建时间',
	modified_on timestamp not null default current_timestamp on update current_timestamp comment '最后修改时间',
	primary key (id)
);