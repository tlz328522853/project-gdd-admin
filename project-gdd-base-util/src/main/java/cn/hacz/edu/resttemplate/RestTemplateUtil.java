package cn.hacz.edu.resttemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

public class RestTemplateUtil {
	public MkRestTemplate restTemplate() {
		MkRestTemplate restTemplate = new MkRestTemplate();
		for (int i = 0; i < restTemplate.getMessageConverters().size();) {
			if (restTemplate.getMessageConverters().get(i).getClass().equals(org.springframework.http.converter.json.MappingJackson2HttpMessageConverter.class)) {
				restTemplate.getMessageConverters().remove(i);
			} else {
				i++;
			}
		}

		FastJsonHttpMessageConverter fastJsonHttpMessageConverter4 = new FastJsonHttpMessageConverter();
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		supportedMediaTypes.add(new MediaType("application", "json", StandardCharsets.UTF_8));
		supportedMediaTypes.add(new MediaType("application", "*+json", StandardCharsets.UTF_8));
		fastJsonHttpMessageConverter4.setSupportedMediaTypes(supportedMediaTypes);
		restTemplate.getMessageConverters().add(0, fastJsonHttpMessageConverter4);
		restTemplate.setMessageConverters(restTemplate.getMessageConverters());

		return restTemplate;
	}

}
