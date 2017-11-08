package cn.hacz.edu.webexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.hacz.edu.resttemplate.MkRestTemplate;
import cn.hacz.edu.resttemplate.RestTemplateUtil;


/**
 * 功能模块：controller的日志、http接口调用
 * 
 * @author guod
 *
 */
@RestController
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	protected RestTemplate restTemplate = new RestTemplate();

	protected MkRestTemplate mkRestTemplate = new MkRestTemplate();

	protected RestTemplateUtil restTemplateUtil = new RestTemplateUtil();
}
