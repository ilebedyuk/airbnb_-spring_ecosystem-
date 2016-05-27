package org.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ilebedyuk
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = {"org.airbnb.domain"})
//@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
//@EnableJpaRepositories(basePackages = "org.airbnb.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class, /*WebAppInitializer.class*/}, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }
}
