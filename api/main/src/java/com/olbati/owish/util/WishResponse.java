package com.olbati.owish.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.olbati.owish.domain.WishInfo;

import java.util.Set;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
public class WishResponse {

    @JsonProperty
    private Set<WishInfo> wishes;

    public WishResponse(Set<WishInfo> wishes) {
        this.wishes = wishes;
    }
}
