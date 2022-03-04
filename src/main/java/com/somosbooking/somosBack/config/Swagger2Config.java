package com.somosbooking.somosBack.config;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.*;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer {

	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).select()
	            .apis(RequestHandlerSelectors
	                .basePackage("com.somosbooking.somosBack"))
	            .paths(PathSelectors.regex("/.*"))
	            .build().apiInfo(apiEndPointsInfo())
	            .securityContexts(Arrays.asList(securityContext()))
	            .securitySchemes(Arrays.asList(apiKey()));
	    }// api
	 
	 private ApiKey apiKey() {
		 return new ApiKey("JWT", "Authorization", "header");
	 }
	 
	 private SecurityContext securityContext() {
		 return SecurityContext.builder().securityReferences(defaultAutho()).build();
	 }
	 
	 private List<SecurityReference> defaultAutho(){
		 AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		 AuthorizationScope[] autorizationScopes = new AuthorizationScope[1];
		 autorizationScopes[0] = authorizationScope;
		 return Arrays.asList(new SecurityReference("JWT", autorizationScopes));
	 }
	 
	private ApiInfo apiEndPointsInfo() {
		 return new ApiInfoBuilder().title("Spring Boot REST API")
		            .description("Login Management REST API")
		            .contact(new Contact("Happy Eight Friends", "URL_HEF", 
		            		"somos.booking2@gmail.com"))
		            .license("Apache 2.0")
		            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
		            .version("1.0.0")
		            .build();
	}//apiEndPointsInfo
	
}//class