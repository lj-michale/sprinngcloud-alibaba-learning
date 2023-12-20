SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `sys_log` (
   `oper_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '日志主键',
   `title` varchar(50) DEFAULT '' COMMENT '模块标题',
   `business_type` int(11) DEFAULT '0' COMMENT '业务类型（0其它 1新增 2修改 3删除）',
   `method` varchar(100) DEFAULT '' COMMENT '方法名称',
   `request_method` varchar(10) DEFAULT '' COMMENT '请求方式',
   `operator_type` int(11) DEFAULT '0' COMMENT '操作类别（ 0、用户端   1、平台管理端）',
   `oper_name` varchar(50) DEFAULT '' COMMENT '操作人员',
   `oper_url` varchar(255) DEFAULT '' COMMENT '请求URL',
   `oper_ip` varchar(128) DEFAULT '' COMMENT '主机地址',
   `oper_location` varchar(255) DEFAULT '' COMMENT '操作地点',
   `oper_param` varchar(2000) DEFAULT '' COMMENT '请求参数',
   `json_result` varchar(2000) DEFAULT '' COMMENT '返回参数',
   `status` int(11) DEFAULT '0' COMMENT '操作状态（1正常 0异常）',
   `error_msg` varchar(2000) DEFAULT '' COMMENT '错误消息',
   `oper_time` datetime DEFAULT NULL COMMENT '操作时间',
   PRIMARY KEY (`oper_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='操作日志记录';


-- ----------------------------
-- Table structure for info_staff
-- ----------------------------
DROP TABLE IF EXISTS `info_staff`;
CREATE TABLE `info_staff`  (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                           `num` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '工号',
                           `realname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '真实姓名',
                           `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '手机号',
                           `id_card` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '身份证号',
                           `sex` int NOT NULL COMMENT '性别 1 男 2 女',
                           `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '地址',
                           `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;
-- ----------------------------
-- Records of info_staff
-- ----------------------------
INSERT INTO `info_staff` VALUES (2, 'A1001', '司机01', '12345677777', '123456789123456780', 2, '西虹市花园小区3号楼5单元', '2022-03-31 12:51:05');
INSERT INTO `info_staff` VALUES (7, 'A1002', '司机02', '12345678915', '123456789123456785', 1, '浙江省杭州市阿狸吧吧', '2022-03-31 22:19:44');
INSERT INTO `info_staff` VALUES (8, 'A1003', '司机03', '12345678910', '123456789123456782', 1, '陕西省西安市', '2022-03-31 22:26:06');
INSERT INTO `info_staff` VALUES (27, 'A1000', '张三', '12345678912', '123456789123456000', 1, '江苏省南京市', '2023-01-18 16:40:31');
INSERT INTO `info_staff` VALUES (31, 'A1004', '张三', '12345678913', '123456789123456001', 2, '北京市', '2023-01-18 16:40:31');
INSERT INTO `info_staff` VALUES (32, 'A1005', '张三', '12345678914', '123456789123456002', 2, '朝阳街', '2023-01-18 16:40:31');
INSERT INTO `info_staff` VALUES (37, 'A1010', '张三', '12345678916', '123456789123456004', 1, '北京市', '2023-01-18 16:40:31');
INSERT INTO `info_staff` VALUES (38, 'A1011', '张三', '12345678917', '123456789123456005', 1, '山西省太原市', '2023-01-18 16:40:31');
INSERT INTO `info_staff` VALUES (39, 'A1012', '张三', '12345678918', '123456789123456006', 2, '山东省青岛市\n', '2023-01-18 16:40:31');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission`  (
                                   `id` int NOT NULL AUTO_INCREMENT COMMENT '权限 ID',
                                   `title` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限名称',
                                   `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限图标',
                                   `href` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限链接 菜单链接',
                                   `spread` bit(1) NULL DEFAULT b'0' COMMENT '是否展开 1 展开 0不展开',
                                   `type` int NOT NULL COMMENT '权限类型 1 菜单 2 按钮',
                                   `tag` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限的表达式',
                                   `sort` int NULL DEFAULT NULL COMMENT '排序值 越大越靠前',
                                   `parent_id` int NOT NULL DEFAULT 0 COMMENT '父权限ID 默认 0 表示一级菜单',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES (1, '系统管理', '&#xe716;', '', b'1', 1, 'sys:admin', 998, 0);
INSERT INTO `sys_permission` VALUES (2, '用户管理', '&#xe613;', 'system/user.do', b'1', 1, 'sys:user', 5, 1);
INSERT INTO `sys_permission` VALUES (3, '角色管理', '&#xe612;', 'system/role.do', b'1', 1, 'sys:role', 4, 1);
INSERT INTO `sys_permission` VALUES (4, '权限管理', '&#xe672;', 'system/permission.do', b'1', 1, 'sys:perm', 3, 1);
INSERT INTO `sys_permission` VALUES (5, '新增用户', '', '', b'0', 2, 'user:add', 0, 2);
INSERT INTO `sys_permission` VALUES (6, '删除用户', '', '', b'0', 2, 'user:delete', 0, 2);
INSERT INTO `sys_permission` VALUES (7, '修改用户', '', '', b'0', 2, 'user:update', 0, 2);
INSERT INTO `sys_permission` VALUES (8, '重置密码', '', '', b'0', 2, 'user:reset', 0, 2);
INSERT INTO `sys_permission` VALUES (9, '设置角色', '', '', b'0', 2, 'user:setRoles', 0, 2);
INSERT INTO `sys_permission` VALUES (10, '信息管理', '&#xe63c;', '', b'1', 1, 'info:admin', 997, 0);
INSERT INTO `sys_permission` VALUES (11, '员工管理', '&#xe770;', 'info/staff.do', b'1', 1, 'info:staff', 5, 10);
INSERT INTO `sys_permission` VALUES (12, '新增员工', '', '', b'0', 2, 'staff:add', 5, 11);
INSERT INTO `sys_permission` VALUES (13, '批量删除员工', '', '', b'0', 2, 'staff:batchDelete', 4, 11);
INSERT INTO `sys_permission` VALUES (14, '导入员工', '', '', b'0', 2, 'staff:import', 3, 11);
INSERT INTO `sys_permission` VALUES (15, '导出员工', '', '', b'0', 2, 'staff:export', 2, 11);
INSERT INTO `sys_permission` VALUES (16, '修改员工', '', '', b'0', 2, 'staff:update', 1, 11);
INSERT INTO `sys_permission` VALUES (17, '删除员工', '', '', b'0', 2, 'tstaff:delete', 0, 11);
INSERT INTO `sys_permission` VALUES (18, '文档管理', '&#xe656;', '', b'0', 1, 'info:douc', 4, 10);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                             `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
                             `tag` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色标识',
                             `descp` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, '系统管理员', 'sys:admin', '负责系统管理');
INSERT INTO `sys_role` VALUES (2, '信息管理员', 'info:admin', '负责员工信息管理，待补充...');
INSERT INTO `sys_role` VALUES (3, '测试管理员', 'tag:test', '测试描述');

-- ----------------------------
-- Table structure for sys_role_per_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_per_rel`;
CREATE TABLE `sys_role_per_rel`  (
                                     `role_id` int NOT NULL COMMENT '角色ID',
                                     `per_id` int NOT NULL COMMENT '权限ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_role_per_rel
-- ----------------------------
INSERT INTO `sys_role_per_rel` VALUES (2, 10);
INSERT INTO `sys_role_per_rel` VALUES (2, 11);
INSERT INTO `sys_role_per_rel` VALUES (2, 12);
INSERT INTO `sys_role_per_rel` VALUES (2, 15);
INSERT INTO `sys_role_per_rel` VALUES (2, 16);
INSERT INTO `sys_role_per_rel` VALUES (1, 1);
INSERT INTO `sys_role_per_rel` VALUES (1, 2);
INSERT INTO `sys_role_per_rel` VALUES (1, 5);
INSERT INTO `sys_role_per_rel` VALUES (1, 6);
INSERT INTO `sys_role_per_rel` VALUES (1, 7);
INSERT INTO `sys_role_per_rel` VALUES (1, 8);
INSERT INTO `sys_role_per_rel` VALUES (1, 9);
INSERT INTO `sys_role_per_rel` VALUES (1, 3);
INSERT INTO `sys_role_per_rel` VALUES (1, 4);
INSERT INTO `sys_role_per_rel` VALUES (1, 10);
INSERT INTO `sys_role_per_rel` VALUES (1, 11);
INSERT INTO `sys_role_per_rel` VALUES (1, 12);
INSERT INTO `sys_role_per_rel` VALUES (1, 13);
INSERT INTO `sys_role_per_rel` VALUES (1, 14);
INSERT INTO `sys_role_per_rel` VALUES (1, 15);
INSERT INTO `sys_role_per_rel` VALUES (1, 16);
INSERT INTO `sys_role_per_rel` VALUES (1, 17);
INSERT INTO `sys_role_per_rel` VALUES (1, 18);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                             `login_name` varchar(15) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登录用户名',
                             `login_password` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '登陆密码',
                             `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '手机号',
                             `realname` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '真实姓名',
                             `id_card` varchar(18) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '身份证号',
                             `sex` int NOT NULL COMMENT '性别 1 男 2 女',
                             `address` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '地址',
                             `img` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '头像',
                             `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', 'b52565aec65fb71daa7b86e1e0ea4296', '12345678901', 'xiuyan', '123456789123456789', 1, '黑龙江省', 'upload/20230118024435047.jpg', '2023-01-17 16:09:26');
INSERT INTO `sys_user` VALUES (2, 'zhangsan', '014985a504fb9f3a97f3f375b91f087f', '12345678902', '万能张三', '123456789123456780', 2, '天津市', 'upload/20230118165912871.jpg', '2023-01-18 16:59:55');
INSERT INTO `sys_user` VALUES (3, 'test', '014985a504fb9f3a97f3f375b91f087f', '12345678903', '无处不在的李四', '123456789123456781', 1, '河南省郑州市', 'upload/20230118171949186.jpg', '2023-01-18 17:20:48');

-- ----------------------------
-- Table structure for sys_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_rel`;
CREATE TABLE `sys_user_role_rel`  (
                                      `user_id` int NOT NULL COMMENT '用户ID',
                                      `role_id` int NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES (1, 1);
INSERT INTO `sys_user_role_rel` VALUES (2, 2);

SET FOREIGN_KEY_CHECKS = 1;












