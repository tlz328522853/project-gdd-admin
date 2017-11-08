package cn.hacz.edu.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.netflix.config.DynamicLongProperty;
import com.netflix.config.DynamicPropertyFactory;

@Controller
public class HttpFullApi {
	@RequestMapping(value = "/httpApiRequest")
	public void httpApiRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		// 这句话的意思，是让浏览器用utf8来解析返回的数据
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		Map<String, Object> postParamMap = new HashMap<String, Object>();
		postParamMap.put("code", "0001");
		postParamMap.put("codeMsg", "调用成功!");
		postParamMap.put("data", "HttpFull风格接口调用");
		postParamMap.put("time", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		postParamMap.put("success", "true");
		String jsonString = JSON.toJSONString(postParamMap);
		DynamicLongProperty timeToWait = DynamicPropertyFactory.getInstance().getLongProperty("lock.waitTime", 1000);
		ReentrantLock lock = new ReentrantLock();
		lock.tryLock(timeToWait.get(), TimeUnit.MILLISECONDS);
		response.getWriter().write(jsonString);
	}
}
