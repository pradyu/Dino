package com.dino;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

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
    	//Change or add the options per performance values 
    	MongoOptions mOps = new MongoOptions();
    	mOps.connectionsPerHost = 10;
    	mOps.threadsAllowedToBlockForConnectionMultiplier = 5;
    	mOps.connectTimeout = 1000;
    	//connection to the default host and port - 127.0.0.1:27017
    	return new Mongo(new ServerAddress(), mOps);
    }
}
