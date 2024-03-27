package com.example.niitiproduct.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class Mail {
    @Value("${spring.mail.host}")
    private String mailHost;
    @Value("${spring.mail.port}")
    private Integer mailPort;
    @Value("${spring.mail.username}")
    private String mailUsername;
    @Value("${spring.mail.password}")
    private String mailPassword;
    @Value("${spring.mail.properties.mail.transport.protocol}")
    private String mailProtocol;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String mailAuth;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String mailStarttlsEnable;
    @Value("${spring.mail.properties.mail.debug}")
    private String mailDebug;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(mailHost);
        mailSender.setPort(mailPort);
        mailSender.setUsername(mailUsername);
        mailSender.setPassword(mailPassword);
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", mailProtocol);
        props.put("mail.smtp.auth", mailAuth);
        props.put("mail.smtp.starttls.enable", mailStarttlsEnable);
        props.put("mail.debug", mailDebug);

        return mailSender;
    }
}
