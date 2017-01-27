package com.olbati.owish.event;

import com.olbati.owish.domain.Wish;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
public class WishEvent extends ApplicationEvent {


    private Wish wish;


    public WishEvent(Object source, Wish wish) {
        //Calling this super class constructor is necessary
        super(source);
        this.wish = wish;
    }

    public Wish getWish() {
        return wish;
    }

    public void setWish(Wish wish) {
        this.wish = wish;
    }
}
