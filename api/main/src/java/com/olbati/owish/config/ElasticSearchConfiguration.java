
package com.olbati.owish.config;

import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;


/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 24/01/2017.
 */


@Configuration
@ComponentScan(basePackageClasses = WishSearchRepository.class)
@EntityScan(basePackageClasses = WishInfo.class)
public class ElasticSearchConfiguration {

    @Value("${elasticsearch.home}")
    private String elasticsearchHome;

    @Autowired
    WishSearchRepository wishRepository;


    @Autowired
    ElasticsearchOperations operations;

    @Bean
    public NodeBuilder nodeBuilder() {
        return new NodeBuilder();
    }

    @Bean
    public NodeClientFactoryBean client() {

        NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
        bean.setClusterName(UUID.randomUUID().toString());
        bean.setEnableHttp(true);
        bean.setPathHome("/");
        bean.setPathData("target/elasticsearchTestData");

        return bean;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
        return new ElasticsearchTemplate(client);
    }

    @PreDestroy
    public void deleteIndex() {
        operations.deleteIndex(WishInfo.class);
    }

    @PostConstruct
    public void insertDataSample() {

        // Remove all documents
        wishRepository.deleteAll();
        operations.refresh(WishInfo.class);

        System.out.println(wishRepository+"pppppp");

        // Save data sample
        WishInfo wish = new WishInfo();
        wishRepository.save(wish);


    }

}

