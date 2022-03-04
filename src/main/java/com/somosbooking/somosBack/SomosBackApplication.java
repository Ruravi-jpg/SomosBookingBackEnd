package com.somosbooking.somosBack;

import com.somosbooking.somosBack.jwt.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application-${spring.profiles.active:default}.properties")
public class SomosBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomosBackApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<JwtFilter> jwtFilter() {
//		FilterRegistrationBean<JwtFilter> registrationBean =
//				new FilterRegistrationBean<>();
//		registrationBean.setFilter( new JwtFilter());
//		//registrationBean.addUrlPatterns("/api/user/*");
//		//registrationBean.addUrlPatterns("/api/article/*");
//		return registrationBean;
//	} // jwtFilter

}
