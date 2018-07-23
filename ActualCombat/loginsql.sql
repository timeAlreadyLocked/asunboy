DROP DATABASE IF EXISTS actual_combat;
CREATE DATABASE actual_combat
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
USE actual_combat;

DROP TABLE IF EXISTS ac_user;
CREATE TABLE ac_user (
  id             BIGINT(20) UNSIGNED                              NOT NULL
  COMMENT '用户ID',
  nickname       VARCHAR(64)
                 CHARACTER SET utf8mb4
                 COLLATE utf8mb4_general_ci                       NOT NULL
  COMMENT '用户网名',
  name           VARCHAR(64) COMMENT '用户真实姓名',
  age            TINYINT UNSIGNED COMMENT '用户真实年龄',
  sex            BIT COMMENT '用户性别',
  mobile         VARCHAR(64) COMMENT '用户电话号码',
  type_id        TINYINT                                          NOT NULL
  COMMENT '用户类型。管理员自定义类型,不同类型的用户权限不一样',
  login_pwd      VARCHAR(128)                                     NOT NULL
  COMMENT '用户登录密码',
  pwd_fail_times TINYINT                                          NOT NULL DEFAULT '0'
  COMMENT '密码登录连续失败次数,登录成功，清除该值',
  status         ENUM ('created', 'enabled', 'locked', 'deleted') NOT NULL
  COMMENT '用户的状态。created(创建的),enabled(启动的),locked(被锁的),deleted(已删除的)',
  locked_on      DATETIME                                                  DEFAULT NULL
  COMMENT '用户被锁时间',
  last_login_on  DATETIME                                                  DEFAULT NULL
  COMMENT '上一次登录成功时间',
  created_on     DATETIME                                         NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  modified_on    TIMESTAMP                                        NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp
  COMMENT '最后修改时间',
  PRIMARY KEY (id)
);
CREATE TABLE ac_login (
  login_name      VARCHAR(128) COMMENT '用户登录名',
  login_type_id   TINYINT    NOT NULL
  COMMENT '登录类型。账号密码登录，第三方登录，短信登录，扫码登录',
  login_target_id BIGINT(20) NOT NULL
  COMMENT '登录后关联的用户ID或第三方Id',
  PRIMARY KEY (login_type_id, login_target_id)
);
CREATE TABLE ac_login_type (
  id      TINYINT UNSIGNED COMMENT '登录类型id',
  name    VARCHAR(64)   NOT NULL
  COMMENT '登录类型名称',
  enabled BIT DEFAULT 1 NOT NULL
  COMMENT '是否启用',
  PRIMARY KEY (id)
);
CREATE TABLE ac_third_party_login (
  user_id              BIGINT(20) UNSIGNED NOT NULL
  COMMENT '用户ID',
  login_type_id        TINYINT             NOT NULL
  COMMENT '登陆类型',
  third_party_login_id BIGINT(20) UNSIGNED NOT NULL
  COMMENT '第三方登录Id',
  PRIMARY KEY (user_id, login_type_id, third_party_login_id)
);
CREATE TABLE ac_session (
  token          VARCHAR(200)             NOT NULL
  COMMENT '用户令牌',
  user_id        BIGINT(20)               NOT NULL
  COMMENT '用户id',
  expire_seconds INT DEFAULT '604800' NOT NULL
  COMMENT '令牌过期时间',
  create_on      DATETIME                 NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (token)
);

CREATE TABLE ac_app_module (
  id          INT UNSIGNED        NOT NULL
  COMMENT '模块id',
  module_key  VARCHAR(64)         NOT NULL
  COMMENT '模块key',
  name        VARCHAR(64)         NOT NULL
  COMMENT '模块名',
  description VARCHAR(200)        NOT NULL
  COMMENT '模块描述',
  create_on   DATETIME            NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by   BIGINT(20) UNSIGNED NOT NULL
  COMMENT '创建者',
  PRIMARY KEY (id)
);