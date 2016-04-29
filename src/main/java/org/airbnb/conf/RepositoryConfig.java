package org.airbnb.conf;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author ilebedyuk
 */
@Configuration
@EnableJpaRepositories(basePackages = "org.airbnb.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.airbnb.model"})
public class RepositoryConfig {
}
