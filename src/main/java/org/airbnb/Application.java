package org.airbnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ilebedyuk
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan(basePackages = {"org.airbnb.domain"})
@EnableJpaRepositories(basePackages = "org.airbnb.repository")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{Application.class, /*ServletContainerCustomizer.class*/}, args);
    }
}
