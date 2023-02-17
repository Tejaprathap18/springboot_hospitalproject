package com.ty.springboot_hospitalproject.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {

		Contact contact = new Contact("ty", "www.ty.com", "ty@gmail.com");

		List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();

		ApiInfo apiInfo = new ApiInfo("hospitalApp", "hospital api v1.0", "version 1.0", "www.tyss.com", contact,
				"tyss875", "www.testyantra.com", vendorExtensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.springboot_hospitalproject")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}
}
