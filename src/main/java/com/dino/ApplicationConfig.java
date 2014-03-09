package com.dino;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.util.logging.Logger;

@ComponentScan
@Import(MongoConfig.class)
@EnableAutoConfiguration
@EnableSpringDataWebSupport
public class ApplicationConfig extends AbstractMongoConfiguration {

    private static Logger LOG = Logger.getLogger(ApplicationConfig.class.getName());

    @Value("${server.port:8080}")
    private int port;

    @Value("${mongodb.uri:mongodb://:@localhost:6379/dino}")
    private MongoURI mongoURI;


    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class, args);
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        return new TomcatEmbeddedServletContainerFactory(this.port);
    }

    @Override
    protected String getDatabaseName() {
        return mongoURI.getDatabase();
    }

    @Override
    public Mongo mongo() throws Exception {
        Mongo mongo = new Mongo(mongoURI);
        return mongo;

    }

    @Bean
    public UserCredentials mongoCredentials() {
        return new UserCredentials(mongoURI.getUsername(), new String(mongoURI.getPassword()));
    }

}
