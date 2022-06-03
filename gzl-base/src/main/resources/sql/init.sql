-- ----------------------------
-- Table structure for t1
-- ----------------------------
DROP TABLE IF EXISTS `t1`;
CREATE TABLE `t1`  (
                       `id` int(11) NOT NULL,
                       `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                       PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t1
-- ----------------------------
INSERT INTO `t1` VALUES (1, '1');
INSERT INTO `t1` VALUES (2, '2');
INSERT INTO `t1` VALUES (3, '3');

SET FOREIGN_KEY_CHECKS = 1;



