package cn.hacz.edu.file;

import java.util.ResourceBundle;

/**
 * project -
 *
 * @author guo
 * @date 日期:2017年8月16日 时间:上午7:57:04
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：属性文件工具类
 */
public class PropertiesFileUtil {

	private ResourceBundle rb = null;

	public PropertiesFileUtil(String bundleFile) {
		rb = ResourceBundle.getBundle(bundleFile);
	}

	public String getValue(String key) {
		return rb.getString(key);
	}
}
