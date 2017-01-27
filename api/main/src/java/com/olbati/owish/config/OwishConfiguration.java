package com.olbati.owish.config;


import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import com.olbati.owish.repository.jpa.WishRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 18/01/2017.
 */
@Configuration
@ComponentScan(basePackageClasses = {WishRepository.class, WishSearchRepository.class})
@Import({CORSFilter.class, ElasticSearchConfiguration.class})
@EnableJpaRepositories(basePackageClasses = {WishRepository.class})
@EnableElasticsearchRepositories(basePackageClasses = WishSearchRepository.class)
@PropertySource({
        "classpath:config/wish-app.properties"
})
public class OwishConfiguration {

}
