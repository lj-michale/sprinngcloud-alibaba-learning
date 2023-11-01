
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_blog_user
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_user`;
CREATE TABLE `t_blog_user`  (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '用户昵称',
  `username` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
  `region` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '国家/地区',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '手机号',
  `email` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '邮箱',
  `avatar` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '用户头像',
  `intro` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '个人介绍',
  `ip_address` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '登录ip',
  `ip_source` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '登录地址',
  `login_type` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '登录方式 (1账号, 2微信, 3Gitee, 4Github)',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `post_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  COMMENT '邮编',
  `deletion_time` datetime(0) NULL DEFAULT NULL COMMENT '注销时间戳',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT 'create time',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT 'update time',
  `del_flag` tinyint(1) DEFAULT NULL COMMENT '删除标识',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `alert_group_un_idx1`(`username`, `nickname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '博客用户信息表' ROW_FORMAT = Dynamic;

INSERT INTO `blog2`.`t_blog_user` (`id`, `nickname`, `username`, `password`, `region`, `phone`, `email`, `avatar`, `intro`, `ip_address`, `ip_source`, `login_type`, `login_time`, `post_code`, `deletion_time`, `create_time`, `update_time`, `del_flag`) VALUES (7137462, '张珊', 'lj.michale', 'Turing@2023', '广东深圳南山区', '18689222595', '2715053558@qq.com', NULL, NULL, '192.168.43.102', '广东深圳南山区桃源街道', '1', '2023-10-23 14:36:55', '415700', '2023-10-23 14:37:14', '2023-10-23 14:37:19', '2023-10-23 14:37:25', 0);
