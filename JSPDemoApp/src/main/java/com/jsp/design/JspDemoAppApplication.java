package com.jsp.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jsp.design")
public class JspDemoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspDemoAppApplication.class, args);
	}

}
