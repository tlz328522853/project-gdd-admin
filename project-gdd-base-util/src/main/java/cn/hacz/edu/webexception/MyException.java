package cn.hacz.edu.webexception;

/**
 * project - 异常统一处理
 *
 * @author guo
 * @date 日期:2017年9月13日 时间:下午5:02:29
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：自定义异常
 */
public class MyException extends RuntimeException {
	private static final long serialVersionUID = -1761865141730477748L;
	private String code;// 错误码

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public MyException(ResultEnum anEnum) {
		super(anEnum.getCodeMsg());
		this.code = anEnum.getCode();
	}
}
