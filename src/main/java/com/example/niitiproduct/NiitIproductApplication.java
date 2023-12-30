package com.example.niitiproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class NiitIproductApplication implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //ref: https://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-static.html
        registry
                .addResourceHandler("/public/**", "/vendors/**")
                .addResourceLocations("/resources/", "classpath:/vendors/", "classpath:/build/", "classpath:/public/");
    }

    public static void main(String[] args) {
        //ApplicationContext context =
        SpringApplication.run(NiitIproductApplication.class, args);
        //context.getBean(UserRepository.class);
    }

}
