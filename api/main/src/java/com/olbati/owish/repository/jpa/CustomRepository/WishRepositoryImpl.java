package com.olbati.owish.repository.jpa.CustomRepository;

import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 26/01/2017.
 */
public class WishRepositoryImpl implements WishRepositoryCustom {

    @Autowired
    WishSearchRepository wishSearchRepository;

    @PostConstruct
    @Override
    public Iterable<WishInfo> getWishList() {
        System.out.println(wishSearchRepository.findAll().iterator().next().getWishName()+"*****");
        return wishSearchRepository.findAll();

    }
}
