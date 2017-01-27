package com.olbati.owish.Service;

import com.olbati.owish.domain.Wish;
import com.olbati.owish.domain.WishInfo;

import java.util.Set;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
public interface WishService {

    Wish addWish(Wish wish);

    WishInfo addWishInfo(WishInfo wish);

    Set<WishInfo> finAllWishes();

}
