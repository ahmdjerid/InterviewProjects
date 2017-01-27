package com.olbati.owish.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 18/01/2017.
 */
//@Document(indexName = "olbati", type = "wish")
@Entity
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonProperty("wishName")
    private String wishName;

    public String getWishName() {
        return wishName;
    }

    public void setWishName(String wishName) {
        this.wishName = wishName;
    }


    public Wish(String wishName) {
        this.wishName = wishName;
    }


    public Wish() {
    }

}
