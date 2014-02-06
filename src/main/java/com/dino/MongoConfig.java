package com.dino;

import com.mongodb.Mongo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * This class sets up the MongoDB Configuration
 */
@ComponentScan
@Configuration
@EnableMongoRepositories
@Profile("prod")
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "dino";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }
}
