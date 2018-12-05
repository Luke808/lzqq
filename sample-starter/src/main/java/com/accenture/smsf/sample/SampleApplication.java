package com.accenture.smsf.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author s.c.gao
 */
@SpringCloudApplication
@Slf4j
public class SampleApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SampleApplication.class, args);
        log.info(" ========== " + applicationContext.getId() + " started ==========");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*");
            }
        };

    }

}
