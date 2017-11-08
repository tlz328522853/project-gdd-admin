package cn.hacz.edu.webexception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * project - 异常统一处理
 *
 * @author guo
 * @date 日期:2017年9月13日 时间:下午5:01:28
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：异常统一处理控制器
 */
@ControllerAdvice
public class ExceptionHandle {
	// 日志记录
	private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	// 时间转换
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public R handle(Exception e) {
		if (e instanceof MyException) {
			MyException myException = (MyException) e;
			return R.build(myException.getCode(), myException.getMessage(), false, df.format(new Date()));
		} else {
			logger.error("[系统异常]={}", e);
			return R.build("-200", "未知错误", false, df.format(new Date()));
		}

	}
}
