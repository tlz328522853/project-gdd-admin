package cn.hacz.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import cn.hacz.edu.base.CustomUserService;

/**
 * Created by sang on 2017/1/10.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	UserDetailsService customUserService() {
		return new CustomUserService();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/upload/**", "/css/**", "/js/**", "/images/**", "/resources/**", "/lib/**",
						"/skin/**", "/template/**", "/common/**", "/404/**", "/admin_files/**", "/echarts/**",
						"/fonts/**", "/notebook/**")
				.permitAll();
	}
}
