package cn.hacz.edu.api;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.hacz.edu.webexception.R;
import io.swagger.annotations.Api;

@Api(value = "接口", description = "测试")
@RestController
public class RestFullApi {
	@GetMapping(value = "/restFullApi")
	public R restFullApi(ModelMap map) {
		String data = "RestFull风格的URL";
		return R.ok(data);
	}

}
