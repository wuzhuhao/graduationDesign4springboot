/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : graduationmanagement

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-02-09 18:29:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log_operation
-- ----------------------------
DROP TABLE IF EXISTS `log_operation`;
CREATE TABLE `log_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `opera_content` text COMMENT '操作内容',
  `opera_role` varchar(255) DEFAULT NULL COMMENT '操作人',
  `opera_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log_operation
-- ----------------------------

-- ----------------------------
-- Table structure for reply_team
-- ----------------------------
DROP TABLE IF EXISTS `reply_team`;
CREATE TABLE `reply_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_name` varchar(255) DEFAULT NULL COMMENT '答辩组名称',
  `team_address` varchar(255) DEFAULT NULL COMMENT '答辩地址',
  `reply_time` datetime DEFAULT NULL COMMENT '答辩时间',
  `team_leader_id` varchar(255) DEFAULT NULL COMMENT '答辩组长id',
  PRIMARY KEY (`id`),
  KEY `team_leader_id` (`team_leader_id`),
  CONSTRAINT `team_leader_id` FOREIGN KEY (`team_leader_id`) REFERENCES `t_teacher` (`tea_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply_team
-- ----------------------------

-- ----------------------------
-- Table structure for t_academy
-- ----------------------------
DROP TABLE IF EXISTS `t_academy`;
CREATE TABLE `t_academy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aca_name` varchar(255) DEFAULT NULL COMMENT '学院名称',
  `aca_introduce` text COMMENT '学院介绍',
  PRIMARY KEY (`id`),
  KEY `id` (`id`,`aca_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_academy
-- ----------------------------
INSERT INTO `t_academy` VALUES ('1', '中山大学南方学院', '哈哈哈哈哈');
INSERT INTO `t_academy` VALUES ('2', '电气与计算机工程学院', '皇后嗷嗷哦嗷嗷');
INSERT INTO `t_academy` VALUES ('3', '会计学院', 's手动阀手动阀手动阀');

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` varchar(255) NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(255) NOT NULL COMMENT '登陆密码',
  `admin_name` varchar(255) DEFAULT NULL COMMENT '管理员名称',
  `admin_sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `admin_age` int(11) DEFAULT NULL COMMENT '年龄',
  `admin_birthday` varchar(255) DEFAULT NULL COMMENT '生日',
  `admin_phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `admin_mail` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `admin_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `admin_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `admin_type` int(11) DEFAULT NULL COMMENT '1是小助手，2是超级管理员',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('admin', '1231231', '张三', '男', '55', '生日', '10086', '111775511@qq.com', '中大南方', null, null);

-- ----------------------------
-- Table structure for t_apply
-- ----------------------------
DROP TABLE IF EXISTS `t_apply`;
CREATE TABLE `t_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_tea_id` varchar(255) DEFAULT NULL COMMENT '申请导师id，外键',
  `apply_content` text COMMENT '申请内容',
  `apply_reason` text COMMENT '申请理由',
  `apply_state` int(11) DEFAULT NULL COMMENT '处理状态，1是待处理，2是已处理',
  `apply_reply` text COMMENT '处理反馈',
  `apply_stu_id` varchar(255) DEFAULT NULL COMMENT '关联学生id',
  `apply_sub_id` varchar(255) DEFAULT NULL COMMENT '关联课题',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_reply_time` datetime DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`id`),
  KEY `apply_tea_id` (`apply_tea_id`),
  CONSTRAINT `apply_tea_id` FOREIGN KEY (`apply_tea_id`) REFERENCES `t_teacher` (`tea_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_apply
-- ----------------------------

-- ----------------------------
-- Table structure for t_designshow
-- ----------------------------
DROP TABLE IF EXISTS `t_designshow`;
CREATE TABLE `t_designshow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `show_sub_id` varchar(255) NOT NULL,
  `show_content` text COMMENT '展示内容',
  `show_file` varchar(255) DEFAULT NULL COMMENT '附件',
  `show_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`),
  KEY `show_sub_id` (`show_sub_id`),
  CONSTRAINT `show_sub_id` FOREIGN KEY (`show_sub_id`) REFERENCES `t_subject` (`sub_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_designshow
-- ----------------------------

-- ----------------------------
-- Table structure for t_goodgraduation
-- ----------------------------
DROP TABLE IF EXISTS `t_goodgraduation`;
CREATE TABLE `t_goodgraduation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_sub_id` varchar(255) DEFAULT NULL COMMENT '外键课题id',
  `good_reason` text COMMENT '评定理由',
  `good_time` datetime DEFAULT NULL COMMENT '评定时间',
  PRIMARY KEY (`id`),
  KEY `goog_sub_id` (`good_sub_id`),
  CONSTRAINT `goog_sub_id` FOREIGN KEY (`good_sub_id`) REFERENCES `t_subject` (`sub_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goodgraduation
-- ----------------------------

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `notice_content` text COMMENT '公告内容',
  `notice_time` datetime DEFAULT NULL COMMENT '公告发布时间',
  `notice_publisher` varchar(255) DEFAULT NULL COMMENT '公告发布人',
  `aca_id` int(11) DEFAULT NULL COMMENT '学院id，外键学院表',
  PRIMARY KEY (`id`),
  KEY `notice_aca_id` (`aca_id`),
  CONSTRAINT `notice_aca_id` FOREIGN KEY (`aca_id`) REFERENCES `t_academy` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `per_name` varchar(100) DEFAULT NULL COMMENT '权限名字',
  `per_desc` varchar(100) DEFAULT NULL COMMENT '权限描述',
  `per_url` varchar(100) DEFAULT NULL COMMENT '权限url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_progress
-- ----------------------------
DROP TABLE IF EXISTS `t_progress`;
CREATE TABLE `t_progress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `progress_sub_id` varchar(255) DEFAULT NULL COMMENT '课题id，外键课题表id',
  `prog_content` text COMMENT '问题内容',
  `prog_content_time` datetime DEFAULT NULL COMMENT '问题发表时间',
  `prog_reply` text COMMENT '导师回复内容',
  `prog_reply_time` datetime DEFAULT NULL COMMENT '导师回复时间',
  PRIMARY KEY (`id`),
  KEY `prog_sub_id` (`progress_sub_id`),
  CONSTRAINT `prog_sub_id` FOREIGN KEY (`progress_sub_id`) REFERENCES `t_subject` (`sub_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_progress
-- ----------------------------
INSERT INTO `t_progress` VALUES ('3', 'DFff0fbf7', 'demoData', '2020-02-09 18:18:36', '测试回复222', '2020-02-09 18:27:06');
INSERT INTO `t_progress` VALUES ('4', 'DFff0fbf7', 'demoData', '2020-02-09 18:18:39', null, null);

-- ----------------------------
-- Table structure for t_report
-- ----------------------------
DROP TABLE IF EXISTS `t_report`;
CREATE TABLE `t_report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `report_sub_id` varchar(255) NOT NULL COMMENT '课题id，外键对课题表id',
  `report_type` int(11) NOT NULL COMMENT '报告类型，1是开题报告，2是论文定稿',
  `report_state` int(11) DEFAULT NULL COMMENT '状态：1是未提交，2是已提交，3是延期提交，4是通过，5是驳回待修改，6是已修改',
  `report_content` text COMMENT '报告内容（使用富文本编辑）',
  `report_subtime` datetime DEFAULT NULL COMMENT '报告提交时间',
  `report_version` float DEFAULT '0' COMMENT '版本信息，默认是0',
  `stu_message` text COMMENT '学生提交反馈信息',
  `tea_suggestion` text COMMENT '导师意见',
  `report_file` varchar(255) DEFAULT NULL COMMENT '报告附件',
  `report_temp` varchar(255) DEFAULT NULL COMMENT '报告模板',
  PRIMARY KEY (`report_sub_id`,`report_type`),
  KEY `report_index_id`  USING BTREE(`id`),
  CONSTRAINT `report_sub_id` FOREIGN KEY (`report_sub_id`) REFERENCES `t_subject` (`sub_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_report
-- ----------------------------
INSERT INTO `t_report` VALUES ('1', 'DFff0fbf7', '1', '2', null, null, '0', null, null, null, null);
INSERT INTO `t_report` VALUES ('2', 'DFff0fbf7', '2', '1', null, null, '0', null, null, null, null);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'assistant', '小助手');
INSERT INTO `t_role` VALUES ('2', 'admin', '超级管理员');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id，外键',
  `per_id` bigint(20) DEFAULT NULL COMMENT '权限id，外键',
  PRIMARY KEY (`id`),
  KEY `rp_per_id` (`per_id`),
  KEY `rp_role_id` (`role_id`),
  CONSTRAINT `rp_per_id` FOREIGN KEY (`per_id`) REFERENCES `t_permission` (`id`) ON DELETE CASCADE,
  CONSTRAINT `rp_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `stu_id` varchar(255) NOT NULL COMMENT '学生登陆账号',
  `stu_password` varchar(255) NOT NULL COMMENT '学生登陆密码',
  `stu_name` varchar(255) NOT NULL COMMENT '学生名称',
  `stu_major` varchar(255) NOT NULL COMMENT '学生专业',
  `stu_class` varchar(255) DEFAULT NULL COMMENT '学生班级',
  `stu_sex` varchar(4) DEFAULT NULL COMMENT '学生年龄',
  `stu_age` int(11) DEFAULT NULL COMMENT '学生年龄',
  `stu_birthday` varchar(255) DEFAULT NULL COMMENT '学生生日',
  `stu_phone` varchar(255) DEFAULT NULL COMMENT '学生电话',
  `stu_mail` varchar(255) DEFAULT NULL COMMENT '学生邮箱',
  `stu_address` varchar(255) DEFAULT NULL COMMENT '学生地址',
  `stu_remarks` varchar(255) DEFAULT NULL COMMENT '优秀毕业生标志位，0是无，1是候选人，2是选上了，3是落选',
  `academy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `stu_academy_id` (`academy_id`),
  CONSTRAINT `stu_academy_id` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('123', '1231231', '叶海涛', '网络工程', '16网工8班', '男', '22', '1997.12.13', '110', 'mail@qq.com', '塘缀', '我是塘缀佬', '3');
INSERT INTO `t_student` VALUES ('162011322', '123123', '吴柱豪', '计算机科学与技术', '16计算机8班', '男', '22', '1997年10月28日', '13413622230', '1376261775@qq.com', '广东广州', '备注', '2');

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `sub_id` varchar(255) NOT NULL COMMENT '课题id',
  `sub_name` varchar(255) NOT NULL COMMENT '课题名称',
  `sub_nature` int(11) NOT NULL COMMENT '课题性质，1是理论性课题，2是实践性课题',
  `sub_source` int(11) DEFAULT NULL COMMENT '课程来源，1是科研题目，2是企业题目，3是自拟题目',
  `sub_introduce` text COMMENT '课题介绍',
  `sub_tea_id` varchar(255) DEFAULT NULL COMMENT '课题导师，外键对教师表',
  `sub_file` varchar(255) DEFAULT NULL COMMENT '课题附件',
  `first_report_deadline` datetime DEFAULT NULL COMMENT '开题报告最后的时间',
  `last_report_deadline` datetime DEFAULT NULL COMMENT '论文定稿最后时间',
  `stu_id` varchar(255) DEFAULT NULL COMMENT '学生id，外键对学生表',
  `sub_stu_state` int(11) DEFAULT '1' COMMENT '选定状态，1是待选定，2是待审核，3是通过',
  `sub_last_score` decimal(10,0) DEFAULT NULL COMMENT '最终评分',
  `show_id` int(11) DEFAULT NULL COMMENT '展示id，外键展示表id',
  PRIMARY KEY (`sub_id`),
  KEY `sub_show_id` (`show_id`),
  KEY `sub_stu_id` (`stu_id`),
  KEY `sub_tea_id` (`sub_tea_id`),
  CONSTRAINT `sub_show_id` FOREIGN KEY (`show_id`) REFERENCES `t_designshow` (`id`),
  CONSTRAINT `sub_stu_id` FOREIGN KEY (`stu_id`) REFERENCES `t_student` (`stu_id`) ON DELETE CASCADE,
  CONSTRAINT `sub_tea_id` FOREIGN KEY (`sub_tea_id`) REFERENCES `t_teacher` (`tea_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('DFce36fe16', '测试修改', '1', '1', '介绍', 'teacher', '测试', '2020-01-23 00:40:00', '2020-01-23 00:40:00', '162011322', '2', null, null);
INSERT INTO `t_subject` VALUES ('DFf4189bd', '测试', '1', '1', '介绍', 'teacher', '测试', '2020-01-23 00:40:00', '2020-01-23 00:40:00', null, '1', null, null);
INSERT INTO `t_subject` VALUES ('DFf7db1f5', '测试', '1', '1', '介绍', 'teacher', '测试', '2020-01-23 00:40:00', '2020-01-23 00:40:00', null, '1', null, null);
INSERT INTO `t_subject` VALUES ('DFfa27693', '测试', '1', '1', '介绍', 'teacher', '测试', '2020-01-23 00:40:00', '2020-01-23 00:40:00', null, '1', null, null);
INSERT INTO `t_subject` VALUES ('DFff0fbf7', '测试', '1', '1', '介绍', 'teacher', '测试', '2020-01-23 00:40:00', '2020-01-23 00:40:00', '162011322', '1', null, null);

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `task_content` text COMMENT '主要内容',
  `task_require` text COMMENT '基本要求',
  `task_schedule` text,
  `task_literature` text COMMENT '应收集的资料及主要参考文献',
  `task_file` varchar(255) DEFAULT NULL COMMENT '任务附件',
  `task_state` varchar(255) DEFAULT NULL COMMENT '任务状态,，1是待接受，2是已接受',
  `task_number` int(11) DEFAULT NULL COMMENT '点击次数',
  `task_sub_id` varchar(255) DEFAULT NULL COMMENT '课题id，外键对应课题表id',
  `reply_content` text COMMENT '回应内容',
  `reply_file` varchar(255) DEFAULT NULL COMMENT '回复附件',
  `task_time` datetime DEFAULT NULL COMMENT '任务发布时间',
  `reply_time` datetime DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`),
  KEY `task_sub_id` (`task_sub_id`),
  CONSTRAINT `task_sub_id` FOREIGN KEY (`task_sub_id`) REFERENCES `t_subject` (`sub_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '任务内容', '任务要求', '任务列表', '文献', '测试问及那哈哈哈哈', '1', '0', 'DFce36fe16', null, null, '2020-01-31 17:59:12', null);
INSERT INTO `t_task` VALUES ('4', '任务内容', '任务要求', '任务列表', '文献', 'tye', '1', '0', 'DFce36fe16', null, null, '2020-01-31 17:59:12', null);
INSERT INTO `t_task` VALUES ('5', '任务内容', '任务要求', '任务列表', '文献', 'tye', '2', '0', 'DFce36fe16', null, null, '2020-01-31 17:59:12', null);

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `tea_id` varchar(255) NOT NULL COMMENT '教师id',
  `tea_password` varchar(255) DEFAULT NULL COMMENT '教师密码',
  `tea_name` varchar(255) DEFAULT NULL COMMENT '教师名称',
  `tea_sex` varchar(4) DEFAULT NULL COMMENT '教师性别',
  `tea_age` int(11) DEFAULT NULL COMMENT '教师年龄',
  `tea_birthday` varchar(255) DEFAULT NULL COMMENT '教师生日',
  `tea_phone` varchar(255) DEFAULT NULL COMMENT '教师电话',
  `tea_mail` varchar(255) DEFAULT NULL COMMENT '教师邮箱',
  `tea_address` varchar(255) DEFAULT NULL COMMENT '教师地址',
  `tea_remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `academy_id` int(11) DEFAULT NULL COMMENT '学院id',
  PRIMARY KEY (`tea_id`),
  KEY `tea_academy_id` (`academy_id`),
  CONSTRAINT `tea_academy_id` FOREIGN KEY (`academy_id`) REFERENCES `t_academy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES ('teacher', '1231231', '李四', '女', '88', '生日', '电话', '邮箱', '广东湛江', null, '2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` varchar(255) DEFAULT NULL COMMENT '管理员id，外键',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色id，外键',
  PRIMARY KEY (`id`),
  KEY `role_admin_id` (`admin_id`),
  KEY `ar_role_id` (`role_id`),
  CONSTRAINT `ar_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`),
  CONSTRAINT `role_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `t_admin` (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
