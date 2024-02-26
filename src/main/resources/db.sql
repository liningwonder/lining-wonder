CREATE TABLE IF NOT EXISTS `t_user`
(
    `id`        INT UNSIGNED AUTO_INCREMENT COMMENT 'cert id',
    `tenant_id`   INT UNSIGNED COMMENT 'tenant id',
    `version`   INT UNSIGNED COMMENT 'version for opt lock',
    `is_delete` BOOLEAN COMMENT 'is_delete',
    `create_time`  DATETIME COMMENT 'create time',
    `update_time`  DATETIME COMMENT 'create time',
    `creator` VARCHAR(500) COMMENT 'creator',
    `operator` VARCHAR(500) COMMENT 'operator',
    `name` VARCHAR(500),
    `phone` VARCHAR(500),
    `email` VARCHAR(500),
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


用户表

机构表        用户组？

机构-用户表

角色表

权限表

机构-角色表

用户-角色表

角色-权限表