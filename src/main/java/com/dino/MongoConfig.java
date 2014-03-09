package com.dino;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.logging.Logger;

/**
 * This class sets up the MongoDB Configuration
 */
@ComponentScan
@Configuration
@EnableMongoRepositories
@Profile("prod")
public class MongoConfig extends AbstractMongoConfiguration {

    private static Logger LOG = Logger.getLogger(MongoConfig.class.getName());

    @Value("${mongodb.uri}")
    private MongoURI mongoURI;

    @Override
    protected String getDatabaseName() {
        LOG.info("Database Name:" + mongoURI.getDatabase());
        return mongoURI.getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        LOG.info("Mongo URL:" + mongoURI);
        Mongo mongo = new Mongo(mongoURI);
        return mongo;
    }

    @Bean
    public UserCredentials mongoCredentials() {
        LOG.info("Mongo URL:" + mongoURI);
        return new UserCredentials(mongoURI.getUsername(), new String(mongoURI.getPassword()));
    }
}
