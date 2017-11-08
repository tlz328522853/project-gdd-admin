package cn.hacz.edu.http;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * project -
 *
 * @author guo
 * @date 日期:2017年8月25日 时间:下午1:54:47
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：
 */
public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
}