package org.airbnb.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ilebedyuk
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"org.airbnb.controller"})
public class MvcConfig {
}
