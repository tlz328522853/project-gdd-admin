package cn.hacz.edu.vrifycode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.ModelMap;

/**
 * project -
 *
 * @author guo
 * @date 日期:2017年8月25日 时间:下午1:24:52
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：验证码工具
 */
public class VrifyCodeUtil {

	public static final String PARAMETERNAME = "vrifyCode";

	private VrifyCodeUtil() {
	}

	/**
	 * 验证码校验逻辑，传入的验证码参数名必须叫 vrifyCode
	 * 
	 * @param httpServletRequest
	 * @param model
	 * @return
	 */
	public static boolean checkvrifyCode(HttpServletRequest httpServletRequest, ModelMap model) {
		String captchaId = (String) httpServletRequest.getSession().getAttribute(PARAMETERNAME);
		String parameter = httpServletRequest.getParameter(PARAMETERNAME);
		if (!captchaId.equals(parameter)) {
			model.addAttribute("error", "验证码不正确！");
			return false;
		}
		return true;
	}

	/**
	 * @param vrifyCode
	 *            验证码
	 * @param httpServletRequest
	 * @return
	 */
	public static boolean checkvrifyCode(String vrifyCode, HttpServletRequest httpServletRequest) {
		String captchaId = (String) httpServletRequest.getSession().getAttribute(PARAMETERNAME);
		if (!captchaId.equals(vrifyCode)) {
			return false;
		}
		return true;
	}

	/**
	 * @param vrifyCode
	 *            验证码
	 * @param session
	 * @return
	 */
	public static boolean checkvrifyCode(String vrifyCode, HttpSession session) {
		String captchaId = (String) session.getAttribute(PARAMETERNAME);
		if (!captchaId.equals(vrifyCode)) {
			return false;
		}
		return true;
	}
}
