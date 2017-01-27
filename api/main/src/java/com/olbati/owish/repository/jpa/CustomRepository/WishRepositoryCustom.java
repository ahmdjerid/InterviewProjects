package com.olbati.owish.repository.jpa.CustomRepository;

import com.olbati.owish.domain.WishInfo;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 26/01/2017.
 */
public interface WishRepositoryCustom {

    Iterable<WishInfo> getWishList();

}
