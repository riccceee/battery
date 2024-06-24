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

 Date: 18/06/2024 23:57:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `vid` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `car_id` int NOT NULL AUTO_INCREMENT COMMENT '车架编号',
  `type` int NULL DEFAULT NULL COMMENT '电池类型\r\n',
  `mile` int NULL DEFAULT NULL COMMENT '总里程(km)',
  `percent` tinyint NULL DEFAULT NULL COMMENT '电池健康状态(%)',
  PRIMARY KEY (`vid`) USING BTREE,
  UNIQUE INDEX `uq_carid`(`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES ('1115331955572102', 2, 2, 600, 95);
INSERT INTO `car` VALUES ('1175120070262640', 3, 1, 300, 98);
INSERT INTO `car` VALUES ('1177541818947648', 1, 1, 100, 100);

SET FOREIGN_KEY_CHECKS = 1;
