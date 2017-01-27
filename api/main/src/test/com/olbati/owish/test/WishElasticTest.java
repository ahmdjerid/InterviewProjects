package com.olbati.owish.test;

import com.olbati.owish.config.OwishConfiguration;
import com.olbati.owish.domain.Wish;
import org.elasticsearch.client.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 24/01/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OwishConfiguration.class)
public class WishElasticTest {

    String jsonString = null;
    Client client = null;


    @Autowired
    protected ElasticsearchTemplate elasticsearchTemplate;

    //@Autowired
    //private WishService wishService;

    @Test
    public void before() {
        elasticsearchTemplate.deleteIndex(Wish.class);
        elasticsearchTemplate.createIndex(Wish.class);

        Wish wish = new Wish("buy car");
       // wishService.save(wish);

    }
}


