package cn.hacz.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * project - spring boot整合
 *
 * @author dong
 * @date 日期:2017年10月11日 时间:下午7:40:36
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：主程序的入口
 */

@SpringBootApplication
@ComponentScan(basePackages = { "cn.hacz.edu" }) // 扫描注解
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
