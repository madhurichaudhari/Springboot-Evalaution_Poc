package com.evaluationtestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.evaluationtestdemo.utils.AppConstant;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author MadhuriC EvaluationTestDemoApplication for Start Application
 */
@SpringBootApplication
@EnableSwagger2
public class EvaluationTestDemoApplication {

	/**
	 * for run Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EvaluationTestDemoApplication.class, args);
	}

	/**
	 * This implementation for Swagger Take 2 parameter
	 * DEFAULT_PRODUCES_AND_CONSUMES DEFAULT_PRODUCES_AND_CONSUMES
	 * 
	 * @return Docket
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(AppConstant.DEFAULT_API_INFO)
				.produces(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(AppConstant.DEFAULT_PRODUCES_AND_CONSUMES);
	}

}
