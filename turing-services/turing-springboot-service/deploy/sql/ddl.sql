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