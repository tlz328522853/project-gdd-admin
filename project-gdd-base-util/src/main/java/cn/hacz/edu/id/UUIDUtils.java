package cn.hacz.edu.id;

import java.util.UUID;

/**
 * project - spring boot整合
 *
 * @author dong
 * @date 日期:2017年10月11日 时间:下午8:48:57
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：生成UUID
 */

public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
