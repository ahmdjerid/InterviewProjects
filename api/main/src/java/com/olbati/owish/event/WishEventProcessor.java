package com.olbati.owish.event;

import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.repository.elasticsearch.WishSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
public class WishEventProcessor  implements ApplicationListener<WishEvent> {

    @Autowired
    WishSearchRepository wishSearchRepository;

    @Override
    public void onApplicationEvent(WishEvent wishEvent) {

        WishInfo wishInfo =new WishInfo(wishEvent.getWish().getWishName());
        wishSearchRepository.save(wishInfo);
    }
}
