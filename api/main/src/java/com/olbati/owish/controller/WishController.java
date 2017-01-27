package com.olbati.owish.controller;

import com.olbati.owish.Service.WishService;
import com.olbati.owish.domain.Wish;
import com.olbati.owish.domain.WishInfo;
import com.olbati.owish.util.WishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 27/01/2017.
 */
@Controller()
@RequestMapping("/api")

public class WishController {
    @Autowired
    WishService wishService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public HttpEntity<Wish> Save(Wish wish) {
        return new ResponseEntity<>(wishService.addWish(wish), HttpStatus.OK);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public HttpEntity<?> getAll() {
        WishInfo wishInfo = new WishInfo("wish 1");
        wishService.addWishInfo(wishInfo);

        Set<WishInfo> wishes = wishService.finAllWishes();
        System.out.println(wishes.iterator().next().getWishName());

        return new ResponseEntity<>(new WishResponse(wishes), HttpStatus.OK);

    }


}
