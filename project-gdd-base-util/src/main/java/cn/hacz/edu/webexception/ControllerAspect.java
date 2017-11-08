package cn.hacz.edu.webexception;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Controller的日志切片
 * 
 * @author 马凯
 * @date 2017-09-14
 */
@Aspect
@Configuration
public class ControllerAspect extends BaseController {
	/**
	 * Logger for this class
	 */

	@Autowired
	private ObjectMapper mapper;

	/**
	 * 所有Controller
	 */
	@Pointcut("execution(public * cn.hacz.edu.school.controller..*Controller.*(..))")
	public void pointcut() {
	}

	/**
	 * Spring 环绕通知 切点
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("pointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {

		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		String url = request.getRequestURL().toString();
		String method = request.getMethod();
		String uri = request.getRequestURI();
		String queryString = request.getQueryString();
		logger.info("============================================");
		logger.info("请求开始, 各个参数, logid:{}, url: {}", url);

		StopWatch watch = new StopWatch(String.valueOf(""));
		watch.start();

		Object result = null;
		R r = null;
		try {
			result = pjp.proceed();
			r = (R) result;
			r.setSuccess(true);
		} catch (Throwable e) {
			logger.error("******************************");
			logger.error("出错详细日志logid:{}, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
			logger.error("出错 logId: " + e);// 此处应该直接落地
			logger.error("******************************");
			throw e;
		}

		watch.stop();
		logger.info("请求结束, 执行时间 {} controller的返回值是 {}", watch.getTotalTimeMillis(), mapper.writeValueAsString(result));
		logger.info("============================================");
		return result;
	}

}
