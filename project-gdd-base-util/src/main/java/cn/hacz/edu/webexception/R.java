package cn.hacz.edu.webexception;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project - 异常统一处理
 *
 * @author guo
 * @date 日期:2017年9月13日 时间:下午5:00:11
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：数据返回格式
 */
public class R {
	/**
	 * 属性：错误码
	 */
	private String code;

	/**
	 * 属性：错误信息
	 */
	private String codeMsg;

	/**
	 * 属性：数据信息
	 */
	private Object data;

	/**
	 * 属性：时间
	 */
	private String time;

	/**
	 * 属性：是否成功
	 */
	private boolean success;

	public R() {
	}

	public static R ok() {
		return new R(null);
	}

	public static R ok(Object data) {
		return new R(data);
	}

	public static R build(String code, String codeMsg, boolean success, String time) {
		return new R(code, codeMsg, null, success, time);
	}

	public static R build(String code, String codeMsg, Object data, boolean success, String time) {
		return new R(code, codeMsg, data, success, time);
	}

	public R(Object data) {
		this.code = "200";
		this.codeMsg = "OK";
		this.data = data;
		this.success = true;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.time = df.format(new Date());
	}

	public R(String code, String codeMsg, Object data, boolean success, String time) {
		this.code = code;
		this.codeMsg = codeMsg;
		this.data = data;
		this.time = time;
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public String getCodeMsg() {
		return codeMsg;
	}

	public Object getData() {
		return data;
	}

	public String getTime() {
		return time;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setCodeMsg(String codeMsg) {
		this.codeMsg = codeMsg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
