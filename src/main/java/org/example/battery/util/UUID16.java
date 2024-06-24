package org.example.battery.util;

import java.util.UUID;

/**
 * @author 14273
 */
public class UUID16 {
    public static String getUUID() {
        // 1.开头两位，标识业务代码或机器代码（可变参数）
        String machineId = String.valueOf(11);
        // 2.生成四位随机整数
        int valueOf = (int)((Math.random()*9+1)*1000);
        // 3.生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        // 4.可能为负数
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        // 5.算法处理: 0-代表前面补充0; 10-代表长度为10; d-代表参数为正数型
        String value = machineId + valueOf + String.format("%010d", hashCode);
        return value;
    }
}
