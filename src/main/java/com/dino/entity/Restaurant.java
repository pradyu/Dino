package com.dino.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Restaurant extends AbstractEntity {

    public Restaurant(String name) {
        this.name = name;
    }

    public Restaurant() {
    }

    @Field("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

