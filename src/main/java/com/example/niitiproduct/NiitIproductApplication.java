package com.example.niitiproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class NiitIproductApplication implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //ref: https://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-serve-static.html
        registry
                .addResourceHandler("/public/**", "/vendors/**")
                .addResourceLocations("/resources/", "classpath:/vendors/", "classpath:/build/", "classpath:/public/");
    }
    public static void main(String[] args) {
        SpringApplication.run(NiitIproductApplication.class, args);
    }

}
