package com.dino.repo;

import com.dino.ApplicationConfig;
import com.dino.entity.Restaurant;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public abstract class AbstractTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Before
    public void setup() {
        mongoTemplate.dropCollection(Restaurant.class);
    }

}
