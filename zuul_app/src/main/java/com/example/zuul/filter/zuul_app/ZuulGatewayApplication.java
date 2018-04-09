package com.example.zuul.filter.zuul_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author ram 
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulGatewayApplication {

	@Bean
	public AddResponseHeaderFilter addResponseHeaderFilter() {
		return new AddResponseHeaderFilter();
	}


	@Bean
	public QueryParamPortPreFilter queryParamPortPreFilter() {
		return new QueryParamPortPreFilter();
	}



	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayApplication.class, args);
	}

}
