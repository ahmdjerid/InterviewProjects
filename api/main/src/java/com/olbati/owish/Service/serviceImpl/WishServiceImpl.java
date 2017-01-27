package com.olbati.owish.Service.serviceImpl;

import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.Wish;
import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.event.WishEvent;
import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import com.olbati.owish.repository.jpa.WishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Service
public class WishServiceImpl implements WishService , ApplicationEventPublisherAware {

    @Autowired
    WishSearchRepository wishSearchRepository;

    @Autowired
    WishRepository wishRepository;

    private ApplicationEventPublisher publisher;

    @Override
    public Wish addWish(Wish wish) {
        publisher.publishEvent(new WishEvent(this, wish));
        return wishRepository.save(wish);

    }


    @Override
    public WishInfo addWishInfo(WishInfo wish) {
        return wishSearchRepository.save(wish);
    }

    @Override
    public Set<WishInfo> finAllWishes() {
        Set<WishInfo> result = new HashSet<>();
        Iterable<WishInfo> wihes = wishSearchRepository.findAll();
        wihes.forEach(result::add);
        return result;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
