/*
 Navicat Premium Data Transfer

 Source Server         : localhost_13306
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:13306
 Source Schema         : battery

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 19/06/2024 00:32:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS `rule`;
CREATE TABLE `rule`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `rule_id` int NULL DEFAULT NULL COMMENT '规则编号',
  `warn_name` char(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '警告名称',
  `type` int NULL DEFAULT NULL COMMENT '电池类型',
  `rule` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '规则列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rule
-- ----------------------------
INSERT INTO `rule` VALUES (1, 1, '电压差报警', 1, '[{\"warnLevel\":0,\"warnExpression\":\"5<=(Mx-Mi)\"},{\"warnLevel\":1,\"warnExpression\":\"3<=(Mx-Mi)&&(Mx-Mi)<5\"},{\"warnLevel\":2,\"warnExpression\":\"1<=(Mx-Mi)&&(Mx-Mi)<3\"},{\"warnLevel\":3,\"warnExpression\":\"0.6<=(Mx-Mi)&&(Mx-Mi)<1\"},{\"warnLevel\":4,\"warnExpression\":\"0.2<=(Mx-Mi)&&(Mx-Mi)<0.6\"},{\"warnLevel\":-1,\"warnExpression\":\"(Mx-Mi)<0.2\"}]');
INSERT INTO `rule` VALUES (2, 1, '电压差报警', 2, '[{\"warnLevel\":0,\"warnExpression\":\"2<=(Mx-Mi)\"},{\"warnLevel\":1,\"warnExpression\":\"1<=(Mx-Mi)&&(Mx-Mi)<2\"},{\"warnLevel\":2,\"warnExpression\":\"0.7<=(Mx-Mi)&&(Mx-Mi)<1\"},{\"warnLevel\":3,\"warnExpression\":\"0.4<=(Mx-Mi)&&(Mx-Mi)<0.7\"},{\"warnLevel\":4,\"warnExpression\":\"0.2<=(Mx-Mi)&&(Mx-Mi)<0.4\"},{\"warnLevel\":-1,\"warnExpression\":\"(Mx-Mi)<0.2\"}]');
INSERT INTO `rule` VALUES (3, 2, '电流差报警', 1, '[{\"warnLevel\":0,\"warnExpression\":\"3<=(Ix-Ii)\"},{\"warnLevel\":1,\"warnExpression\":\"1<=(Ix-Ii)&&(Ix-Ii)<3\"},{\"warnLevel\":2,\"warnExpression\":\"0.2<=(Ix-Ii)&&(Ix-Ii)<1\"},{\"warnLevel\":-1,\"warnExpression\":\"(Ix-Ii)<0.2\"}]');
INSERT INTO `rule` VALUES (4, 2, '电流差报警', 2, '[{\"warnLevel\":0,\"warnExpression\":\"1<=(Ix-Ii)\"},{\"warnLevel\":1,\"warnExpression\":\"0.5<=(Ix-Ii)&&(Ix-Ii)<1\"},{\"warnLevel\":2,\"warnExpression\":\"0.2<=(Ix-Ii)&&(Ix-Ii)<0.5\"},{\"warnLevel\":-1,\"warnExpression\":\"(Ix-Ii)<0.2\"}]');

SET FOREIGN_KEY_CHECKS = 1;
